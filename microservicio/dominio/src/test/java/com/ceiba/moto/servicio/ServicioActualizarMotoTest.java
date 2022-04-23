package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ServicioActualizarMotoTest {
    private static final Long ID = 1L;

    @Test
    @DisplayName("Validar si la moto no existe")
    public void verificarSiNoExisteLaMoto() {
        // Arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarMoto servicioActualizarMoto = new ServicioActualizarMoto(repositorioMoto);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioActualizarMoto.ejecutar(moto), ExcepcionSinDatos.class, "La moto no existe en el sistema");
    }

    @Test
    @DisplayName("Validar que la moto se actualice correctamente")
    public void verificarNoExistencia() {
        // Arrange
        Moto moto = new MotoTestDataBuilder().conId(ID).build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        doNothing().when(repositorioMoto).actualizar(moto);
        ServicioActualizarMoto servicioActualizarMoto = new ServicioActualizarMoto(repositorioMoto);
        // Act
        servicioActualizarMoto.ejecutar(moto);
        // Assert
        verify(repositorioMoto, times(1)).actualizar(moto);
    }
}
