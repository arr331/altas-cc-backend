package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCotizacion;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.compra.servicio.ServicioCotizacion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCotizacion implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Cotizacion>> {
    private final ServicioCotizacion servicioCotizacion;
    private final FabricaCotizacion fabricaCotizacion;

    public ManejadorCotizacion(ServicioCotizacion servicioCotizacion, FabricaCotizacion fabricaCotizacion) {
        this.servicioCotizacion = servicioCotizacion;
        this.fabricaCotizacion = fabricaCotizacion;
    }

    @Override
    public ComandoRespuesta<Cotizacion> ejecutar(Long id) {
        Cotizacion cotizacion = this.fabricaCotizacion.crear(id);
        return new ComandoRespuesta<>(this.servicioCotizacion.ejecutar(cotizacion));
    }
}
