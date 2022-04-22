package com.ceiba.moto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MotoTest {
    @Test
    @DisplayName("Deberia crear correctamente la moto")
    void deberiaCrearCorrectamenteLaMoto() {
        // arrange
        int descuento = 10;
        //act
        Moto moto = new MotoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, moto.getId());
        assertNotEquals(0, moto.getPrecio());
        assertNotEquals(349, moto.getCc());
        assertEquals("Super Duke 1290", moto.getNombreMoto());
        assertEquals("super-duke.png", moto.getNombreImagen());
        assertEquals("KTM", moto.getMarca());
        assertEquals("A", moto.getEstado());
        assertEquals(descuento, moto.getDescuento());
        assertEquals(3, moto.getCantidad());
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre de la moto")
    void deberiaFallarSinNombreMoto() {
        // arrange - act
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conNombre(null);
        //assert
        BasePrueba.assertThrows(() -> {
            motoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "El campo nombre es obligatorio");
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre de la imagen")
    void deberiaFallarSinNombreImagen() {
        // arrange - act
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conNombreImagen(null);
        //assert
        BasePrueba.assertThrows(() -> {
            motoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "El campo nombre de la imagen es obligatorio");
    }

    @Test
    @DisplayName("Deberia fallar sin el nombre de la imagen")
    void deberiaFallarSiElValorEsMenorQue1000() {
        // arrange - act
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPrecio(950);
        //assert
        BasePrueba.assertThrows(() -> {
            motoTestDataBuilder.build();
        }, ExcepcionValorInvalido.class, "El precio mínimo de una moto es 1000 USD");
    }
}
