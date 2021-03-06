package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<String>> {
    private final FabricaCompra fabricaCompra;
    private final ServicioCrearCompra servicioCrearCompra;

    public ManejadorCrearCompra(FabricaCompra fabricaCompra, ServicioCrearCompra servicioCrearCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioCrearCompra = servicioCrearCompra;
    }

    @Override
    public ComandoRespuesta<String> ejecutar(ComandoCompra comando) {
        Compra compra = fabricaCompra.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearCompra.ejecutar(compra));
    }
}
