package com.ceiba.compra.modelo.entidad;

import com.ceiba.moto.modelo.entidad.Moto;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@NoArgsConstructor
public class Cotizacion {
    private static final String MENSAJE_MOTO_OBLIGATORIO = "La compra debe tener una moto";

    private static final double PORCENTAJE_IMPUESTO = 2;
    private static final double PORCENTAJE_DESCUENTO_LUNES = 1.5;
    private static final double PORCENTAJE_DESCUENTO_FIN_DE_SEMANA = 1;
    private static final double UNO = 1;
    private static final double CIEN = 100;
    private static final int CC_PARA_DESCUENTO = 600;
    private static final double PRECIO_USD_PARA_IMPUESTO = 15000;

    private Moto moto;
    private double valorSinDescuento;
    private double valorFinal;
    private double impuesto; // 2%
    private double descuentoLunes; // 1.5%
    private double descuentoFinDeSemana; // 1%

    public Cotizacion(Moto moto) {
        validarObligatorio(moto, MENSAJE_MOTO_OBLIGATORIO);

        this.moto = moto;
        generar();
    }

    private void generar() {
        LocalDate fechaActual = LocalDate.now();

        double valorFinal = obtenerPorcionDelPorcentaje(this.moto.getPrecio(), this.moto.getDescuento());

        if (fechaActual.getDayOfWeek() == DayOfWeek.MONDAY) {
            valorFinal = obtenerPorcionDelPorcentaje(valorFinal, PORCENTAJE_DESCUENTO_LUNES);
            this.descuentoLunes = PORCENTAJE_DESCUENTO_LUNES;
        }
        if (this.moto.getCc() < CC_PARA_DESCUENTO && (fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY || fechaActual.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            valorFinal = obtenerPorcionDelPorcentaje(valorFinal, PORCENTAJE_DESCUENTO_FIN_DE_SEMANA);
            this.descuentoFinDeSemana = PORCENTAJE_DESCUENTO_FIN_DE_SEMANA;
        }
        if (this.moto.getPrecio() > PRECIO_USD_PARA_IMPUESTO) {
            valorFinal = valorFinal * (UNO + (PORCENTAJE_IMPUESTO / CIEN));
            this.impuesto = PORCENTAJE_IMPUESTO;
        }

        this.valorFinal = valorFinal;
        this.valorSinDescuento = this.moto.getPrecio();
    }

    private double obtenerPorcionDelPorcentaje(double valor, double porcentajeDescuento) {
        return valor * ((CIEN - porcentajeDescuento) / CIEN);
    }

    public Moto getMoto() {
        return moto;
    }

    public double getValorSinDescuento() {
        return valorSinDescuento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getDescuentoLunes() {
        return descuentoLunes;
    }

    public double getDescuentoFinDeSemana() {
        return descuentoFinDeSemana;
    }
}
