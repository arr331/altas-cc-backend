package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.compra.servicio.testdatabuilder.CotizacionTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCotizacionTest {
    private static final int CANTIDAD_CERO = 0;

    @Test
    @DisplayName("Validar unidades disponibles")
    void validarUnidadesDisponibles() {
        // Arrange
        Moto moto = new MotoTestDataBuilder().conCantidad(CANTIDAD_CERO).build();
        Cotizacion cotizacion = new CotizacionTestBuilder().conMoto(moto).build();
        ServicioCotizacion servicioCotizacion = new ServicioCotizacion();
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCotizacion.ejecutar(cotizacion), ExcepcionSinDatos.class,
                "Esta moto no está disponible para su compra");
    }
}
