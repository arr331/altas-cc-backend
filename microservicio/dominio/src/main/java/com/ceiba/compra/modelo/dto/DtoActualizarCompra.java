package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DtoActualizarCompra {
    private Long id;
    private double abono;
    private String estado;

    public Long getId() {
        return id;
    }

    public double getAbono() {
        return abono;
    }

    public String getEstado() {
        return estado;
    }
}
