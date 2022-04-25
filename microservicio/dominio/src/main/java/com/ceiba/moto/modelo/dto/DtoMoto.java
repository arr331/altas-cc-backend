package com.ceiba.moto.modelo.dto;

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

    public DtoMoto(Long id, double precio, int cc, String marca, String estado, double descuento, String nombreImagen, String nombreMoto, int cantidad) {
        this.id = id;
        this.precio = precio;
        this.cc = cc;
        this.marca = marca;
        this.estado = estado;
        this.descuento = descuento;
        this.nombreImagen = nombreImagen;
        this.nombreMoto = nombreMoto;
        this.cantidad = cantidad;
    }

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
