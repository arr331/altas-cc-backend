package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoDetallePago;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioDetallePagoTest {
    private static final Long ID_MOTO = 1L;

    @Test
    @DisplayName("Validar que la moto si exista")
    void validarExisteMoto() {
        // Arrange
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioDetallePago servicioDetallePago = new ServicioDetallePago(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(false);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioDetallePago.ejecutar(ID_MOTO), ExcepcionSinDatos.class,
                "La moto no existe en el sistema");
    }

    @Test
    @DisplayName("Validar unidades disponibles")
    void validarUnidadesDisponibles() {
        // Arrange
        int cantidad = 0;
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioDetallePago servicioDetallePago = new ServicioDetallePago(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().buildDto(cantidad)); // Como seria?

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioDetallePago.ejecutar(ID_MOTO), ExcepcionSinDatos.class,
                "Esta moto no está disponible para su compra");
    }

    @Test
    @DisplayName("Verificar que se incluya el impuesto")
    void verificarQueSeIncluyaElImpuesto() {
        // Arrange
        int cantidad = 1;
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioDetallePago servicioDetallePago = new ServicioDetallePago(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().buildDto(cantidad));
        // Act
        DtoDetallePago dtoDetallePago = servicioDetallePago.ejecutar(ID_MOTO);
        // Assert
        assertEquals(2, dtoDetallePago.getImpuesto());
    }
}
