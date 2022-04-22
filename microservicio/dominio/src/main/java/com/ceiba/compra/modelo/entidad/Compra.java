package com.ceiba.compra.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Setter
@Getter
public class Compra {
    private static final String MENSAJE_ID_MOTO_OBLIGATORIO = "La compra debe tener una moto";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA = "El campo cédula es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA = "El campo nombre completo es obligatorio";

    private static final String MENSAJE_VALOR_TOTAL_POSITIVO = "El valor total de la compra debe ser positivo";
    private static final String MENSAJE_ABONO_POSITIVO = "El valor del abono de la compra debe ser positivo";

    private Long id;
    private Long idMoto;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;

    public static Compra of(Long id, Long idMoto, String cedula, String nombreCompleto, LocalDateTime fecha, double valorTotal, double abono, String codigo, String estado) {
        validarObligatorio(idMoto, MENSAJE_ID_MOTO_OBLIGATORIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA);
        validarObligatorio(nombreCompleto, SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA);

        validarPositivo(valorTotal, MENSAJE_VALOR_TOTAL_POSITIVO);
        validarPositivo(abono, MENSAJE_ABONO_POSITIVO);

        return new Compra(id, idMoto, cedula, nombreCompleto, fecha, valorTotal, abono, codigo, estado);
    }

    private Compra(Long id, Long idMoto, String cedula, String nombreCompleto, LocalDateTime fecha, double valorTotal, double abono, String codigo, String estado) {
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
}
