package com.ceiba.compra.modelo.dto;

import java.time.LocalDateTime;

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

    public DtoCompra(Long id, Long idMoto, String cedula, String nombreCompleto, LocalDateTime fecha, double valorTotal, double abono, String codigo, String estado) {
        this.id = id;
        this.idMoto = idMoto;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.abono = abono;
        this.codigo = codigo;
        this.estado = estado;
    }

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
