package com.ceiba.compra.comando.manejador;

import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCompra {
    private final FabricaCompra fabricaCompra;
    private final ServicioActualizarCompra servicioActualizarCompra;

    public ManejadorActualizarCompra(FabricaCompra fabricaCompra, ServicioActualizarCompra servicioActualizarCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioActualizarCompra = servicioActualizarCompra;
    }

    public void ejecutar(String codigo) {
        servicioActualizarCompra.ejecutar(codigo);
    }
}
