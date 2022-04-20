package com.ceiba.moto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMoto {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private int descuento;
    private String nombreImagen;
    private String nombreMoto;
}
