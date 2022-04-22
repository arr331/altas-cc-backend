package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearMotoTest {
    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";
    private static final Long ID_RESPUESTA = 1L;

    @Test
    @DisplayName("Validar que la moto exista")
    public void verificarExistencia() {
        // Arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMoto servicioCrearMoto = new ServicioCrearMoto(repositorioMoto);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearMoto.ejecutar(moto), ExcepcionDuplicidad.class, LA_MOTO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Validar que la moto no exista")
    public void verificarNoExistencia() {
        // Arrange
        Moto moto = new MotoTestDataBuilder().build();
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioMoto.crear(moto)).thenReturn(ID_RESPUESTA);
        ServicioCrearMoto servicioCrearMoto = new ServicioCrearMoto(repositorioMoto);

        // Act - Assert
        assertEquals (ID_RESPUESTA, servicioCrearMoto.ejecutar(moto));
    }

}