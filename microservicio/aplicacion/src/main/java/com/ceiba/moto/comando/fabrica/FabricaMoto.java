package com.ceiba.moto.comando.fabrica;

import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import org.springframework.stereotype.Component;

@Component
public class FabricaMoto {
    public Moto crear(ComandoMoto comandoMoto) {
        return Moto.of(
                comandoMoto.getId(),
                comandoMoto.getPrecio(),
                comandoMoto.getCc(),
                comandoMoto.getMarca(),
                comandoMoto.getEstado(),
                comandoMoto.getDescuento(),
                comandoMoto.getNombreImagen(),
                comandoMoto.getNombreMoto()
        );
    }
}
