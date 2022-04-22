package com.ceiba.moto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.manejador.ManejadorActualizarMoto;
import com.ceiba.moto.comando.manejador.ManejadorCrearMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motos")
@Api(tags={"Controlador comando motos"})
public class ComandoControladorMoto {
    private final ManejadorCrearMoto manejadorCrearMoto;
    private final ManejadorActualizarMoto manejadorActualizarMoto;

    @Autowired
    public ComandoControladorMoto(ManejadorCrearMoto manejadorCrearMoto, ManejadorActualizarMoto manejadorActualizarMoto) {
        this.manejadorCrearMoto = manejadorCrearMoto;
        this.manejadorActualizarMoto = manejadorActualizarMoto;
    }

    @PostMapping
    @ApiOperation("Crear Moto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMoto comandoMoto) {
        return manejadorCrearMoto.ejecutar(comandoMoto);
    }

    @PutMapping
    @ApiOperation("Actualizar Moto")
    public void actualizar(@RequestBody ComandoMoto comandoMoto) {
        manejadorActualizarMoto.ejecutar(comandoMoto);
    }
}
