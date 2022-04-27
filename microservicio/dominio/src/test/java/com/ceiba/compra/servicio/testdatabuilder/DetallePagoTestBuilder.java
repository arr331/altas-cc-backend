package com.ceiba.compra.servicio.testdatabuilder;

public class DetallePagoTestBuilder {
    private double valorSinDescuento;
    private double valorFinal;
    private double impuesto;
    private double descuentoLunes;
    private double descuentoFinDeSemana;

    public DetallePagoTestBuilder() {
        this.valorSinDescuento = 14000;
        this.valorFinal = 12740;
        this.impuesto = 0;
        this.descuentoLunes = 0;
        this.descuentoFinDeSemana = 0;
    }

    public DetallePagoTestBuilder conValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
        return this;
    }

    public DtoDetallePago build()  { return new DtoDetallePago(valorSinDescuento, valorFinal, impuesto, descuentoLunes, descuentoFinDeSemana); }
}
