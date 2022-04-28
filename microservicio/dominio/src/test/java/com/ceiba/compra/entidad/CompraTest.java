package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompraTest {
    private static final String ESTADO_COMPLETO = "C";
    private static final String ESTADO_INCOMPLETO = "I";
    private static final double ABONO_15000 = 15000;
    private static final double ABONO_NEGATIVO = -15000;

    @Test
    @DisplayName("Debería crear la compra")
    void deberiaCrearCompra() {
        // Arrange - Act
        Compra compra = new CompraTestBuilder().build();
        String codigo = compra.abonar();
        // Assert
        assertEquals("1040048300", compra.getCedula());
        assertEquals("Adrian Ramírez", compra.getNombreCompleto());
        assertEquals(ESTADO_COMPLETO, compra.getEstado());
        assertEquals(codigo, compra.getCodigo());
    }

    @Test
    @DisplayName("Debería crear la compra incompleta")
    void deberiaCrearCompraIncompleta() {
        // Arrange - Act
        Compra compra = new CompraTestBuilder().conAbono(ABONO_15000).build();
        compra.abonar();
        // Assert
        assertEquals(ESTADO_INCOMPLETO, compra.getEstado());
    }

    @Test
    @DisplayName("Deberia fallar sin no tiene cotización")
    void deberiaFallarSinCotizacion() {
        // arrange - act
        CompraTestBuilder compraTestBuilder = new CompraTestBuilder().conCotizacion(null);
        //assert
        BasePrueba.assertThrows(() -> {
            compraTestBuilder.build();
        }, ExcepcionValorObligatorio.class, "La compra debe tener una cotización");
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre de la persona que compra")
    void deberiaFallarSinNombreCompleto() {
        // arrange - act
        CompraTestBuilder compraTestBuilder = new CompraTestBuilder().conNombreCompleto(null);
        //assert
        BasePrueba.assertThrows(() -> {
            compraTestBuilder.build();
        }, ExcepcionValorObligatorio.class, "El campo nombre completo es obligatorio");
    }

    @Test
    @DisplayName("Deberia fallar si el abono no es mayor que 0, positivo")
    void deberiaFallaConAbonoNegativo() {
        // arrange - act
        CompraTestBuilder compraTestBuilder = new CompraTestBuilder().conAbono(ABONO_NEGATIVO);
        //assert
        BasePrueba.assertThrows(() -> {
            compraTestBuilder.build();
        }, ExcepcionValorInvalido.class, "El valor del abono de la compra debe ser positivo");
    }
}
