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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCompra.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCompraTest {
    private static final String CODIGO_EXISTENTE = "2022-3";
    private static final String CODIGO_NO_EXISTENTE = "2022-1";
    private static final Long ID_MOTO = 1L;

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
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería actualizar una compra")
    void deberiaActualizarCompra() throws Exception {
        // Arrange
        // Act - Assert
        mocMvc.perform(put("/compras/actualizar/" + CODIGO_EXISTENTE, "codigo"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("No debería actualizar una compra, porque el código no existe")
    void noDeberiaActualiszarCompra() throws Exception {
        MvcResult mvcResult =  mocMvc.perform(put("/compras/actualizar/" + CODIGO_NO_EXISTENTE, "codigo"))
                .andExpect(status().is4xxClientError()).andReturn();
        assertEquals("{\"nombreExcepcion\":\"ExcepcionSinDatos\",\"mensaje\":\"Lo sentimos, no se encrontro una compra pendiente con este codigo\"}",
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Debería crear una cotización")
    void deberiaCrearUnaCotizacion() throws Exception {
        // Arrange

        // Act - Assert
        mocMvc.perform(get("/compras/cotizacion/" + ID_MOTO, "idMoto"))
//                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk());
//                .andExpect(con);
    }
}
