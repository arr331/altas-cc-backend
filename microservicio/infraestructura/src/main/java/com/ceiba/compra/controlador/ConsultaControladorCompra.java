package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListarCompras;
import com.ceiba.compra.consulta.ManejadorTraerCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags={"Controlador consulta compras"})
public class ConsultaControladorCompra {
    private final ManejadorListarCompras manejadorListarCompras;
    private final ManejadorTraerCompra manejadorTraerCompra;

    public ConsultaControladorCompra(ManejadorListarCompras manejadorListarCompras, ManejadorTraerCompra manejadorTraerCompra) {
        this.manejadorListarCompras = manejadorListarCompras;
        this.manejadorTraerCompra = manejadorTraerCompra;
    }

    @GetMapping
    @ApiOperation("Listar compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }

    @GetMapping("{id}")
    @ApiOperation("Traer compra por código")
    public DtoCompra traer(@PathVariable Long id) {
        System.out.println(id + " skjdskdkkskd");
        return this.manejadorTraerCompra.ejecutar(id);
    }

//    @GetMapping DONDE VA??
//    @ApiOperation("Información de pago para la compra")
//    public List<DtoInformacionCompra> informacionCompra() {
//        return this.manejadorListarCompras.ejecutar();
//    }
}
