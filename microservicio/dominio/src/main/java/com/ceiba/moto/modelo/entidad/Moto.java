package com.ceiba.moto.modelo.entidad;

import lombok.Getter;

@Getter
public class Moto {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private int descuento;
    private String nombreImagen;
    private String nombreMoto;

    public static Moto of(Long id, double precio, int cc, String marca, String estado, int descuento, String nombreImagen, String nombreMoto) {


        return new Moto(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto);
    }

    private Moto(Long id, double precio, int cc, String marca, String estado, int descuento, String nombreImagen, String nombreMoto) {
        this.id = id;
        this.precio = precio;
        this.cc = cc;
        this.marca = marca;
        this.estado = estado;
        this.descuento = descuento;
        this.nombreImagen = nombreImagen;
        this.nombreMoto = nombreMoto;
    }
}
