package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Cotizacion;

import java.time.LocalDateTime;

public class ComandoCompraTestDataBuilder {
    private Cotizacion cotizacion;
    private String cedula;
    private String nombreCompleto;
    private double abono;

    public ComandoCompraTestDataBuilder() {
        this.cotizacion = new CotizacionTestDataBuilder().build();
        this.cedula = "1040048300";
        this.nombreCompleto = "Adrian Ramírez";
        this.abono = 22050;
    }

    public ComandoCompraTestDataBuilder conCotizacion() {
        this.cotizacion = cotizacion;
        return this;
    }

    public ComandoCompraTestDataBuilder conNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public ComandoCompraTestDataBuilder conValorAbono(double abono) {
        this.abono = abono;
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(this.cotizacion, this.cedula, this.nombreCompleto, this.abono);
    }
}
