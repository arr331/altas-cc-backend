package com.ceiba.compra.entidad;

import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.compra.servicio.testdatabuilder.CotizacionTestBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotizacionTest {
    private static final double PORCENTAJE_IMPUESTO = 2;
    private static final double PORCENTAJE_DESCUENTO_LUNES = 1.5;
    private static final double PORCENTAJE_DESCUENTO_FIN_DE_SEMANA = 1;
    private static final double UNO = 1;
    private static final double CIEN = 100;
    private static final int CC_PARA_DESCUENTO = 600;
    private static final double PRECIO_USD_PARA_IMPUESTO = 15000;

    @Test
    @DisplayName("Debería incluir impuesto del 2% por valer más de 15000 USD")
    void verificarImpuestoPorValorSuperiorA15000USD() {
        // Arrange
        double impuesto = 0;
        //  Act
        Cotizacion cotizacion = new CotizacionTestBuilder().build();
        // Assert
        if (cotizacion.getMoto().getPrecio() > PRECIO_USD_PARA_IMPUESTO) {
            impuesto = PORCENTAJE_IMPUESTO;
        }
        assertEquals(impuesto, cotizacion.getImpuesto());
    }

    @Test
    @DisplayName("Debería incluir descuento por ser lunes")
    void verificarDescuentoPorSerLunes() {
        // Arrange
        double descuentoLunes = 0;
        //  Act
        Cotizacion cotizacion = new CotizacionTestBuilder().build();
        // Assert
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.getDayOfWeek() == DayOfWeek.MONDAY) {
            descuentoLunes = PORCENTAJE_DESCUENTO_LUNES;
        }
        assertEquals(descuentoLunes, cotizacion.getDescuentoLunes());
    }

    @Test
    @DisplayName("Debería incluir descuento por ser fin de semana y la moto tener menos de 600cc")
    void verificarDescuentoPorFinDeSemanaYSerMenorDe600Cc() {
        // Arrange
        double descuentoFinDeSemana = 0;
        //  Act
        Cotizacion cotizacion = new CotizacionTestBuilder().build();
        // Assert
        LocalDate fechaActual = LocalDate.now();
        if (cotizacion.getMoto().getCc() < CC_PARA_DESCUENTO && (fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY || fechaActual.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            descuentoFinDeSemana = PORCENTAJE_DESCUENTO_FIN_DE_SEMANA;
        }
        assertEquals(descuentoFinDeSemana, cotizacion.getDescuentoFinDeSemana());
    }
}
