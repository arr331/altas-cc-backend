package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DtoDetallePago {
    private double valorSinDescuento;
    private double valorFinal;
    private double impuesto; // 2%
    private double descuentoLunes; // 1.5%
    private double descuentoFinDeSemana; // 1%

    public double getValorSinDescuento() {
        return valorSinDescuento;
    }

    public void setValorSinDescuento(double valorSinDescuento) {
        this.valorSinDescuento = valorSinDescuento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getDescuentoLunes() {
        return descuentoLunes;
    }

    public void setDescuentoLunes(double descuentoLunes) {
        this.descuentoLunes = descuentoLunes;
    }

    public double getDescuentoFinDeSemana() {
        return descuentoFinDeSemana;
    }

    public void setDescuentoFinDeSemana(double descuentoFinDeSemana) {
        this.descuentoFinDeSemana = descuentoFinDeSemana;
    }
}
