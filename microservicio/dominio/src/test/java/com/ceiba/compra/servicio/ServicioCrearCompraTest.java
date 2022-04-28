package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearCompraTest {
    private static final double VALOR_ABONO = 12000;
    private static final String ESTADO_COMPLETO = "C";
    private static final String ESTADO_INCOMPLETO = "I";

    @Test
    @DisplayName("Validar que el estado de la compra sea completa")
    void validarCompraConEstadoCompleta() {
        // Arrange
        Compra compra = new CompraTestBuilder().build();
        compra.abonar();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // Act
        servicioCrearCompra.ejecutar(compra);
        // Assert
        assertEquals(ESTADO_COMPLETO, compra.getEstado());
    }

    @Test
    @DisplayName("Validar que el estado de la compra sea incompleta")
    void validarCompraConEstadoIncompleta() {
        // Arrange
        Compra compra = new CompraTestBuilder().conAbono(VALOR_ABONO).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // Act
        servicioCrearCompra.ejecutar(compra);
        // Assert
        assertEquals(ESTADO_INCOMPLETO, compra.getEstado());
    }
}
