package com.ceiba.moto.comando;

public class ComandoMoto {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private double descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;

    public ComandoMoto() {
        // Es intencional
    }

    public ComandoMoto(Long id, double precio, int cc, String marca, String estado, double descuento, String nombreImagen, String nombreMoto, int cantidad) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getNombreMoto() {
        return nombreMoto;
    }

    public void setNombreMoto(String nombreMoto) {
        this.nombreMoto = nombreMoto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
