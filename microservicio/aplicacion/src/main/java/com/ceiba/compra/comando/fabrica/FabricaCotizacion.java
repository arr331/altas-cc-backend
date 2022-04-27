package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

@Component
public class FabricaCotizacion {
    private final DaoMoto daoMoto;

    public FabricaCotizacion(DaoMoto daoMoto) {
        this.daoMoto = daoMoto;
    }

    public Cotizacion crear(Long id) {
        DtoMoto dtoMoto = this.daoMoto.traerPorId(id);
        Moto moto = Moto.of(
                dtoMoto.getId(),
                dtoMoto.getPrecio(),
                dtoMoto.getCc(),
                dtoMoto.getMarca(),
                dtoMoto.getEstado(),
                dtoMoto.getDescuento(),
                dtoMoto.getNombreImagen(),
                dtoMoto.getNombreMoto(),
                dtoMoto.getCantidad()
        );

        return new Cotizacion(moto);
    }
}
