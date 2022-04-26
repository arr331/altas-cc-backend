package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.servicio.testdatabuilder.ComandoCompraTestDataBuilder;
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
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCompra.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCompraTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debería crear una compra")
    void deberiaCrearCompra() throws Exception {
        // Arrange
        ComandoCompra comandoCompra = new ComandoCompraTestDataBuilder().build();
        // Act - Assert
        mocMvc.perform(post("/compras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCompra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}")); // De donde valor
    }

    @Test
    @DisplayName("Debería actualizar una compra")
    void deberiaActualizarCompra() throws Exception {
        // Arrange
        // Act - Assert
        mocMvc.perform(put("/compras/actualizar/2022-1", "codigo"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("No debería actualizar una compra porque no existe")
    void noDeberiaActualizarCompra() throws Exception {
        // Arrange
        // Act - Assert
        MvcResult mvcResult =  mocMvc.perform(put("/compras/actualizar/2022-4", "codigo"))
                .andExpect(status().is4xxClientError()).andReturn();
        assertEquals("{\"nombreExcepcion\":\"ExcepcionSinDatos\",\"mensaje\":\"Lo sentimos, la compra no existe en el sistema\"}",
                mvcResult.getResponse().getContentAsString());
    }
}
