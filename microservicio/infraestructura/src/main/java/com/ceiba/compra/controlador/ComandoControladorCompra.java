package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorCotizacion;
import com.ceiba.compra.modelo.entidad.Cotizacion;
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
    private final ManejadorCotizacion manejadorCotizacion;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra, ManejadorActualizarCompra manejadorActualizarCompra, ManejadorCotizacion manejadorCotizacion) {
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
        this.manejadorCotizacion = manejadorCotizacion;
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

    @GetMapping("/cotizacion/{idMoto}")
    @ApiOperation("Información de pago para la compra")
    public ComandoRespuesta<Cotizacion> cotizacionCompra(@PathVariable Long idMoto) {
        return this.manejadorCotizacion.ejecutar(idMoto);
    }
}
