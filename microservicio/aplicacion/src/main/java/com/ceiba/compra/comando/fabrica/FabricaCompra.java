package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {
    public Compra crear(ComandoCompra comandoCompra) {
        return Compra.of(
                comandoCompra.getId(),
                comandoCompra.getIdMoto(),
                comandoCompra.getCedula(),
                comandoCompra.getNombreCompleto(),
                comandoCompra.getFecha(),
                comandoCompra.getValorTotal(),
                comandoCompra.getAbono(),
                comandoCompra.getCodigo(),
                comandoCompra.getEstado()
        );
    }
}
