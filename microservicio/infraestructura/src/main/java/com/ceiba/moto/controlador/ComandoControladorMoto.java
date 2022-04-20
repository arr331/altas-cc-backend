package com.ceiba.moto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.manejador.ManejadorCrearMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motos")
@Api(tags={"Controlador comando motos"})
public class ComandoControladorMoto {
    private final ManejadorCrearMoto manejadorCrearMoto;

    @Autowired
    public ComandoControladorMoto(ManejadorCrearMoto manejadorCrearMoto) {
        this.manejadorCrearMoto = manejadorCrearMoto;
    }

    @PostMapping
    @ApiOperation("Crear Moto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMoto comandoMoto) {
        return manejadorCrearMoto.ejecutar(comandoMoto);
    }
}
