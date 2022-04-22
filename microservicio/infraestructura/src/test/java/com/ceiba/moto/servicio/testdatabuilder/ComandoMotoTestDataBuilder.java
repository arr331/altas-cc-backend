package com.ceiba.moto.servicio.testdatabuilder;

import com.ceiba.moto.comando.ComandoMoto;

public class ComandoMotoTestDataBuilder {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private double descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;

    public ComandoMotoTestDataBuilder() {
        this.id = 7L;
        this.precio = 24500;
        this.cc = 1299;
        this.marca = "KTM";
        this.estado = "A";
        this.descuento = 10;
        this.nombreImagen = "super-duke.png";
        this.nombreMoto = "Super Duke 1290";
        this.cantidad = 3;
    }

    public ComandoMoto build() {
        return new ComandoMoto(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto, cantidad);
    }
}
