package com.ceiba.moto.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Moto {
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_MOTO = "El campo precio es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_CC_DE_LA_MOTO = "El campo cc es obligatorio";
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO = "El campo marca es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_DE_LA_MOTO = "El campo estado es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_DESCUENTO_DE_LA_MOTO = "El campo descuento es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_IMAGEN_DE_LA_MOTO = "El campo nombre de la imagen es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MOTO = "El campo nombre es obligatorio";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_LA_MOTOS = "El campo cantidad de motos es obligatorio";

    private static final String VALOR_DEL_PRECIO_MENOR_QUE_1000_USD = "El precio mínimo de una moto es 1000 USD";
    private static final long VALOR_MINIMO_USD = 1000;

    private static final String CILINDRAJE_MINIMO_MENSAJE = "El cilindraje mínimo de una moto es 350cc";
    private static final long CILINDRAJE_MINIMO = 350;

    private static final String VALOR_DESCUENTO_POSITIVO = "El valor del descuento debe ser positivo";
    private static final String VALOR_CANTIDAD_POSITIVO = "El valor de la cantidad de motos debe ser positivo";

    private Long id;
    private double precio;
    private int cc;
    private String marca;
    private String estado;
    private double descuento;
    private String nombreImagen;
    private String nombreMoto;
    private int cantidad;

    public static Moto of(Long id, double precio, int cc, String marca, String estado, double descuento, String nombreImagen, String nombreMoto, int cantidad) {
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_MOTO);
        validarObligatorio(cc, SE_DEBE_INGRESAR_EL_CC_DE_LA_MOTO);
        validarObligatorio(marca, SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_DE_LA_MOTO);
        validarObligatorio(descuento, SE_DEBE_INGRESAR_EL_DESCUENTO_DE_LA_MOTO);
        validarObligatorio(nombreImagen, SE_DEBE_INGRESAR_EL_NOMBRE_IMAGEN_DE_LA_MOTO);
        validarObligatorio(nombreMoto, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MOTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_LA_MOTOS);

        validarMenor(VALOR_MINIMO_USD, (long) precio, VALOR_DEL_PRECIO_MENOR_QUE_1000_USD);
        validarMenor(CILINDRAJE_MINIMO, (long) cc, CILINDRAJE_MINIMO_MENSAJE);

        validarPositivo(descuento, VALOR_DESCUENTO_POSITIVO);
        validarPositivo((double) cantidad, VALOR_CANTIDAD_POSITIVO);

        return new Moto(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto, cantidad);
    }

    private Moto(Long id, double precio, int cc, String marca, String estado, double descuento, String nombreImagen, String nombreMoto, int cantidad) {
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
}
