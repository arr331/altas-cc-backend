package com.ceiba.compra.modelo.entidad;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

public final class Compra {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
