package com.ceiba.moto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.servicio.testdatabuilder.ComandoMotoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorMoto.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorMotoTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debería crea una moto")
    void deberiaCrearMoto() throws Exception {
        // Arrange
        ComandoMoto comandoMoto = new ComandoMotoTestDataBuilder().build();
        // Act - Assert
        mocMvc.perform(post("/motos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoMoto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 7}")); // De donde valor
    }

    @Test
    @DisplayName("Debería crea una moto")
    void deberiaActualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoMoto comandoMoto = new ComandoMotoTestDataBuilder().conId(id).conNombreMoto("Ktm Super Duke 1290 Editada").build();

        // act - assert
        mocMvc.perform(put("/motos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoMoto)))
                .andExpect(status().isOk());
    }
}
