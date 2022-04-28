package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.moto.modelo.entidad.Moto;

public class CotizacionTestDataBuilder {
    private Moto moto;
    private double valorSinDescuento;
    private double valorFinal;
    private double impuesto; // 2%
    private double descuentoLunes; // 1.5%
    private double descuentoFinDeSemana; // 1%

    public CotizacionTestDataBuilder() {
        this.moto = new MotoTestDataBuilder().build();
        this.valorSinDescuento = 24500.0;
        this.valorFinal = 22491.0;
        this.impuesto = 2.0;
        this.descuentoLunes = 0;
        this.descuentoFinDeSemana = 0;
    }

    public CotizacionTestDataBuilder conMoto(Moto moto) {
        this.moto = moto;
        return this;
    }

    public CotizacionTestDataBuilder conValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
        return this;
    }

    public Cotizacion build() {
        return new Cotizacion(this.moto);
    }
}
