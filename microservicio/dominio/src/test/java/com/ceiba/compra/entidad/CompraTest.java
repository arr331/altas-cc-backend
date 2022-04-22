package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompraTest {
    @Test
    @DisplayName("Debería crear la compra")
    void deberiaCrearCompra() {
        // Arrange
        LocalDateTime fecha = LocalDateTime.now();
        // Act
        Compra compra = new CompraTestBuilder().conFecha(fecha).build();
        compra.setIdMoto(2L);
        // Assert
        assertEquals(1, compra.getId());
        assertEquals(2, compra.getIdMoto());
        assertEquals("1040048300", compra.getCedula());
        assertEquals("Adrian Ramírez", compra.getNombreCompleto());
        assertEquals(fecha, compra.getFecha());
        assertEquals(22050, compra.getValorTotal());
        assertEquals(22050, compra.getAbono());
        assertEquals("2021-1", compra.getCodigo());
        assertEquals("C", compra.getEstado());
    }

    @Test
    @DisplayName("Deberia fallar sin el id de la moto")
    void deberiaFallarSinIdMoto() {
        // arrange - act
        CompraTestBuilder compraTestBuilder = new CompraTestBuilder().conIdMoto(null);
        //assert
        BasePrueba.assertThrows(() -> {
            compraTestBuilder.build();
        }, ExcepcionValorObligatorio.class, "La compra debe tener una moto");
    }

    @Test
    @DisplayName("Deberia fallar sin el id de la moto")
    void deberiaFallarSinNombreCompleto() {
        // arrange - act
        CompraTestBuilder compraTestBuilder = new CompraTestBuilder().conNombreCompleto(null);
        //assert
        BasePrueba.assertThrows(() -> {
            compraTestBuilder.build();
        }, ExcepcionValorObligatorio.class, "El campo nombre completo es obligatorio");
    }
}
