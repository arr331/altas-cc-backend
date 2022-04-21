package com.ceiba.compra.comando.manejador;

import com.ceiba.compra.modelo.dto.DtoDetallePago;
import com.ceiba.compra.servicio.ServicioDetallePago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorInformacionCompra {
    private final ServicioDetallePago servicioDetallePago;

    public ManejadorInformacionCompra(ServicioDetallePago servicioDetallePago) {
        this.servicioDetallePago = servicioDetallePago;
    }

    public DtoDetallePago ejecutar(Long idMoto) {
        return servicioDetallePago.ejecutar(idMoto);
    }
}
