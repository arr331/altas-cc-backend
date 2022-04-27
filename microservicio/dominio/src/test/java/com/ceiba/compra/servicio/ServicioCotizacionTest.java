package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCotizacionTest {
    private static final Long ID_MOTO = 1L;
    private static final double PORCENTAJE_IMPUESTO = 2;
    private static final double PORCENTAJE_DESCUENTO_LUNES = 1.5;
    private static final double PORCENTAJE_DESCUENTO_FIN_DE_SEMANA = 1;
    private static final int CC_500 = 500;
    private static final int CC_700 = 700;
    private static final int CANTIDAD_CERO = 0;

    @Test
    @DisplayName("Validar que la moto si exista")
    void validarExisteMoto() {
        // Arrange
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(false);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCotizacion.ejecutar(ID_MOTO), ExcepcionSinDatos.class,
                "La moto no existe en el sistema");
    }

    @Test
    @DisplayName("Validar unidades disponibles")
    void validarUnidadesDisponibles() {
        // Arrange
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().conCantidad(CANTIDAD_CERO).buildDto());

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCotizacion.ejecutar(ID_MOTO), ExcepcionSinDatos.class,
                "Esta moto no está disponible para su compra");
    }

    @Test
    @DisplayName("Verificar que se incluya el impuesto")
    void verificarQueSeIncluyaElImpuesto() {
        // Arrange
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().buildDto());
        // Act
        DtoDetallePago dtoDetallePago = servicioCotizacion.ejecutar(ID_MOTO);
        // Assert
        assertEquals(PORCENTAJE_IMPUESTO, dtoDetallePago.getImpuesto());
    }

    @Test
    @DisplayName("Verificar que se incluya el descuento del lunes")
    void verificarQueSeIncluyaElDescuentoDelLunes() {
        // Arrange
        double descuentoLunes = 0;
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().buildDto());
        // Act
        DtoDetallePago dtoDetallePago = servicioCotizacion.ejecutar(ID_MOTO);
        if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
            descuentoLunes = PORCENTAJE_DESCUENTO_LUNES;
        }
        // Assert
        assertEquals(descuentoLunes, dtoDetallePago.getDescuentoLunes());
    }

    @Test
    @DisplayName("Verificar que se incluya el descuento del fin de semana")
    void verificarQueSeIncluyaElDescuentoDelFinDeSemana() {
        // Arrange
        double descuentoFinDeSemana = 0;
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().conCc(CC_500).buildDto());
        // Act
        DtoDetallePago dtoDetallePago = servicioCotizacion.ejecutar(ID_MOTO);
        if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SATURDAY || LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            descuentoFinDeSemana = PORCENTAJE_DESCUENTO_FIN_DE_SEMANA;
        }
        // Assert
        assertEquals(descuentoFinDeSemana, dtoDetallePago.getDescuentoFinDeSemana());
    }

    @Test
    @DisplayName("Verificar que no incluya el descuento del fin de semana por superar cc")
    void verificarQueNoIncluyaElDescuentoDelFinDeSemanaPorSuperarCc() {
        // Arrange
        double descuentoFinDeSemana = 0;
        RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
        DaoMoto daoMoto = Mockito.mock(DaoMoto.class);
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion(repositorioMoto, daoMoto);
        Mockito.when(repositorioMoto.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoMoto.traerPorId(Mockito.anyLong())).thenReturn(new MotoTestDataBuilder().conCc(CC_700).buildDto());
        // Act
        DtoDetallePago dtoDetallePago = servicioCotizacion.ejecutar(ID_MOTO);
        // Assert
        assertEquals(descuentoFinDeSemana, dtoDetallePago.getDescuentoFinDeSemana());
    }
}
