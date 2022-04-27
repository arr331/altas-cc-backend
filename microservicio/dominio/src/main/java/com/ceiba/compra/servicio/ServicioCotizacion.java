package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioCotizacion {
    private static final String MENSAJE_SIN_UNIDADES_DISPONIBLES = "Esta moto no está disponible para su compra";

    public Cotizacion ejecutar(Cotizacion cotizacion) {
        verificarUnidadesDisponibles(cotizacion.getMoto().getCantidad());
        return cotizacion;
    }

    private void verificarUnidadesDisponibles(int unidadesDisponibles) {
        if (unidadesDisponibles < 1 ) {
            throw new ExcepcionSinDatos(MENSAJE_SIN_UNIDADES_DISPONIBLES);
        }
    }
}
