package com.ceiba.moto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMoto {
    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private int descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;
}
