package com.ceiba.moto.controlador;

import com.ceiba.moto.consulta.ManejadorListarMotos;
import com.ceiba.moto.modelo.dto.DtoMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/motos")
@Api(tags={"Controlador consulta motos"})
public class ConsultaControladorMoto {

    private final ManejadorListarMotos manejadorListarMotos;

    public ConsultaControladorMoto(ManejadorListarMotos manejadorListarMotos) {
        this.manejadorListarMotos = manejadorListarMotos;
    }

    @GetMapping
    @ApiOperation("Listar motos")
    public List<DtoMoto> listar() {
        return this.manejadorListarMotos.ejecutar();
    }
}
