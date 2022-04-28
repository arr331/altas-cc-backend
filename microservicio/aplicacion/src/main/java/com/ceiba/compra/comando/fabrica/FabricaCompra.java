package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra crear(ComandoCompra comandoCompra) {
        return Compra.of(
                comandoCompra.getCotizacion(),
                comandoCompra.getCedula(),
                comandoCompra.getNombreCompleto(),
                comandoCompra.getAbono()
        );
    }
}
