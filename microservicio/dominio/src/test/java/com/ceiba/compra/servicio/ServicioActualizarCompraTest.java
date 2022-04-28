package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ServicioActualizarCompraTest {
    private static final String CODIGO_COMPRA_NO_EXISTE = "2022-4";
    private static final String CODIGO_COMPRA_EXISTE = "2022-3";

    @Test
    @DisplayName("Debería validar que la compra no sea encontrada por el código")
    void verificarQueLaCompraNoSeEncuentre() {
        // Arrange
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existeCompraIncompletaPorCodigo(CODIGO_COMPRA_NO_EXISTE)).thenReturn(false);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(CODIGO_COMPRA_NO_EXISTE), ExcepcionSinDatos.class,
                "Lo sentimos, no se encrontro una compra pendiente con este codigo");
    }

    @Test
    @DisplayName("Validar que la compra se encuentre correctamente")
    public void verificarQueLaCompraSeEncuentre() {
        // Arrange
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existeCompraIncompletaPorCodigo(CODIGO_COMPRA_EXISTE)).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // Act
        servicioActualizarCompra.ejecutar(CODIGO_COMPRA_EXISTE);
        // Assert
        verify(repositorioCompra, times(1)).existeCompraIncompletaPorCodigo(CODIGO_COMPRA_EXISTE);
    }

    @Test
    @DisplayName("Validar que la compra se actualice correctamente")
    public void verificarQueSeActualiceLaCompra() {
        // Arrange
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existeCompraIncompletaPorCodigo(CODIGO_COMPRA_EXISTE)).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // Act
        servicioActualizarCompra.ejecutar(CODIGO_COMPRA_EXISTE);
        // Assert
        verify(repositorioCompra, times(1)).actualizar(CODIGO_COMPRA_EXISTE);
    }

}
