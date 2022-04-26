package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorInformacionCompra;
import com.ceiba.compra.modelo.dto.DtoDetallePago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@Api(tags = {"Controlador comando compras"})
public class ComandoControladorCompra {
    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;
    private final ManejadorInformacionCompra manejadorInformacionCompra;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra, ManejadorActualizarCompra manejadorActualizarCompra, ManejadorInformacionCompra manejadorInformacionCompra) {
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
        this.manejadorInformacionCompra = manejadorInformacionCompra;
    }

    @PostMapping
    @ApiOperation("Crear compra")
    public ComandoRespuesta<String> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @PutMapping("/actualizar/{codigo}")
    @ApiOperation("Actualizar compra")
    public void actualizar(@PathVariable String codigo) {
        manejadorActualizarCompra.ejecutar(codigo);
    }

    @GetMapping("/informacion-compra/{idMoto}")
    @ApiOperation("Información de pago para la compra")
    public DtoDetallePago informacionCompra(@PathVariable Long idMoto) {
        return this.manejadorInformacionCompra.ejecutar(idMoto);
    }
}
