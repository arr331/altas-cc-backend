package com.ceiba.moto.servicio.testdatabuilder;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.modelo.entidad.Moto;

public class MotoTestDataBuilder {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private double descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;

    public MotoTestDataBuilder() {
        this.id = 1L;
        this.precio = 24500;
        this.cc = 1299;
        this.marca = "KTM";
        this.estado = "A";
        this.descuento = 10;
        this.nombreImagen = "super-duke.png";
        this.nombreMoto = "Super Duke 1290";
        this.cantidad = 3;
    }

    public MotoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MotoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public MotoTestDataBuilder conCc(int cc) {
        this.cc = cc;
        return this;
    }

    public MotoTestDataBuilder conNombre(String nombreMoto) {
        this.nombreMoto = nombreMoto;
        return this;
    }

    public MotoTestDataBuilder conNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
        return this;
    }

    public MotoTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public DtoMoto buildDto() { return new DtoMoto(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto, cantidad); }

    public Moto build() { return Moto.of(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto, cantidad); }
}
