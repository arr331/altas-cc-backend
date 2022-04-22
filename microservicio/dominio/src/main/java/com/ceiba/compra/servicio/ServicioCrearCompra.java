package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoDetallePago;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;

import java.time.LocalDateTime;

public class ServicioCrearCompra {
    private static final String MENSAJE_ABONO_SUPERIOR_AL_VALOR_FINAL = "El valor a pagar no puede superar el valor de pago final";
    private static final String MENSAJE_ABONO_INSUFICIENTE_PARA_PRECOMPRA = "El valor a pagar debe ser mínimo la mitad  del valor de pago final, Valor mínimo: $%s";
    private static final String COMPRA_COMPLETA = "C";
    private static final String COMPRA_INCOMPLETA = "I";
    private static final double MITAD = 2;

    private final RepositorioCompra repositorioCompra;
    private final ServicioDetallePago servicioDetallePago;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, ServicioDetallePago servicioDetallePago) {
        this.repositorioCompra = repositorioCompra;
        this.servicioDetallePago = servicioDetallePago;
    }

    public Long ejecutar(Compra compra) {
        DtoDetallePago dtoDetallePago = servicioDetallePago.ejecutar(compra.getIdMoto());
        validarRangoDelAbono(dtoDetallePago.getValorFinal(), compra.getAbono());

        if (compra.getAbono() == dtoDetallePago.getValorFinal()) {
            compra.setEstado(COMPRA_COMPLETA);
            compra.setValorTotal(dtoDetallePago.getValorFinal());
        } else {
            compra.setEstado(COMPRA_INCOMPLETA);
            compra.setValorTotal(dtoDetallePago.getValorSinDescuento());
        }
        compra.setFecha(LocalDateTime.now());
        compra.setCodigo(String.valueOf(System.currentTimeMillis()));

        return repositorioCompra.crear(compra);
    }

    private void validarRangoDelAbono(double valorFinal, double abono) {
        if (abono > valorFinal) {
            throw new ExcepcionLongitudValor(MENSAJE_ABONO_SUPERIOR_AL_VALOR_FINAL);
        }
        if (abono < (valorFinal / MITAD)) {
            throw new ExcepcionLongitudValor(String.format(MENSAJE_ABONO_INSUFICIENTE_PARA_PRECOMPRA, valorFinal / MITAD));
        }
    }
}
