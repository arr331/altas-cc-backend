package com.ceiba.compra.adaptador.dto;

public class DtoActualizarCompra {
    private Long id;
    private double abono;
    private String estado;

    public DtoActualizarCompra(Long id, double abono, String estado) {
        this.id = id;
        this.abono = abono;
        this.estado = estado;
    }
}
