package com.ceiba.moto.modelo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DtoMoto {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private double descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCc() {
        return cc;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public String getNombreMoto() {
        return nombreMoto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
