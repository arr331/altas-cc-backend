package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoDetallePago;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioDetallePago {
    private static final double PORCENTAJE_IMPUESTO = 2;
    private static final double PORCENTAJE_DESCUENTO_LUNES = 1.5;
    private static final double PORCENTAJE_DESCUENTO_FIN_DE_SEMANA = 1;
    private static final double UNO = 1;
    private static final double CIEN = 100;
    private static final int CC_PARA_DESCUENTO = 600;
    private static final double PRECIO_USD_PARA_IMPUESTO = 15000;
    private static final String MENSAJE_MOTO_NO_EXITE = "La moto no existe en el sistema";
    private static final String MENSAJE_SIN_UNIDADES_DISPONIBLES = "Esta moto no está disponible para su compra";

    private final RepositorioMoto repositorioMoto;
    private final DaoMoto daoMoto; // No se si va acá porque no hay servicio para consulta

    public ServicioDetallePago(RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        this.repositorioMoto = repositorioMoto;
        this.daoMoto = daoMoto;
    }

    public DtoDetallePago ejecutar(Long idMoto) {
        DtoMoto dtoMoto = traerMoto(idMoto);
        verificarUnidadesDisponibles(dtoMoto.getCantidad());

        return obtenerDetalleDePago(dtoMoto);
    }

    private DtoDetallePago obtenerDetalleDePago(DtoMoto dtoMoto) {
        DtoDetallePago dtoDetallePago = new DtoDetallePago();
        LocalDate fechaActual = LocalDate.now();

        double valorFinal = obtenerPorcionDelPorcentaje(dtoMoto.getPrecio(), dtoMoto.getDescuento()); // Descuento por configuración

        if (fechaActual.getDayOfWeek() == DayOfWeek.MONDAY) {
            valorFinal = obtenerPorcionDelPorcentaje(valorFinal, PORCENTAJE_DESCUENTO_LUNES);
            dtoDetallePago.setDescuentoLunes(PORCENTAJE_DESCUENTO_LUNES);
        }
        if (dtoMoto.getCc() < CC_PARA_DESCUENTO && (fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY || fechaActual.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            valorFinal = obtenerPorcionDelPorcentaje(valorFinal, PORCENTAJE_DESCUENTO_FIN_DE_SEMANA);
            dtoDetallePago.setDescuentoFinDeSemana(PORCENTAJE_DESCUENTO_FIN_DE_SEMANA);
        }
        if (dtoMoto.getPrecio() > PRECIO_USD_PARA_IMPUESTO) {
            valorFinal = valorFinal * (UNO + (PORCENTAJE_IMPUESTO / CIEN)); // Como es por ser fórmula -> 1 ?
            dtoDetallePago.setImpuesto(PORCENTAJE_IMPUESTO);
        }

        dtoDetallePago.setValorFinal(valorFinal);
        dtoDetallePago.setValorSinDescuento(dtoMoto.getPrecio());

        return dtoDetallePago;
    }

    private double obtenerPorcionDelPorcentaje(double valor, double porcentajeDescuento) {
        return valor * ((CIEN - porcentajeDescuento) / CIEN);
    }

    private DtoMoto traerMoto(Long idMoto) {
        boolean existeMoto = repositorioMoto.existePorId(idMoto);
        if (!existeMoto) {
            throw new ExcepcionSinDatos(MENSAJE_MOTO_NO_EXITE);
        }

        return daoMoto.traerPorId(idMoto);
    }

    private void verificarUnidadesDisponibles(int unidadesDisponibles) {
        if (unidadesDisponibles < 1 ) {
            throw new ExcepcionSinDatos(MENSAJE_SIN_UNIDADES_DISPONIBLES);
        }
    }
}
