package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long idMoto;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;

    public Long getId() {
        return id;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getAbono() {
        return abono;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }
}
