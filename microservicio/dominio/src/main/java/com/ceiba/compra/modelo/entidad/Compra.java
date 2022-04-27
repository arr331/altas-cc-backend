package com.ceiba.compra.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.moto.modelo.entidad.Moto;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

public final class Compra {
    private static final String MENSAJE_MOTO_OBLIGATORIO = "La compra debe tener una moto";
    private static final String MENSAJE_COTIZACION_OBLIGATORIO = "La compra debe tener una cotización";

    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA = "El campo cédula es obligatorio";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA = "El campo nombre completo es obligatorio";

    private static final String MENSAJE_ABONO_POSITIVO = "El valor del abono de la compra debe ser positivo";

    private static final String MENSAJE_ABONO_SUPERIOR_AL_VALOR_FINAL = "El valor a pagar no puede superar el valor de pago final";
    private static final String MENSAJE_ABONO_INSUFICIENTE_PARA_PRECOMPRA = "El valor a pagar debe ser mínimo la mitad  del valor de pago final, Valor mínimo: $%s";
    private static final String COMPRA_COMPLETA = "C";
    private static final String COMPRA_INCOMPLETA = "I";
    private static final double MITAD = 2;

    private Long id;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;
    private Cotizacion cotizacion;

    public static Compra of(Long id, Cotizacion cotizacion, String cedula, String nombreCompleto, double abono) {
        validarObligatorio(cotizacion.getMoto(), MENSAJE_MOTO_OBLIGATORIO);
        validarObligatorio(cotizacion, MENSAJE_COTIZACION_OBLIGATORIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DE_LA_PERSONA);
        validarObligatorio(nombreCompleto, SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA);
        validarPositivo(abono, MENSAJE_ABONO_POSITIVO);
        return new Compra(id, cotizacion, cedula, nombreCompleto, abono);
    }

    private Compra(Long id, Cotizacion cotizacion, String cedula, String nombreCompleto, double abono) {
        this.id = id;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fecha = LocalDateTime.now();
        this.valorTotal = cotizacion.getValorFinal();
        this.abono = abono;
        this.cotizacion = cotizacion;
    }

    public String abonar(){
        validarRangoDelAbono(cotizacion.getValorFinal(), this.getAbono());

        if (this.abono == this.cotizacion.getValorFinal()) {
            this.estado = COMPRA_COMPLETA;
            this.valorTotal = cotizacion.getValorFinal();
        } else {
            this.estado = COMPRA_INCOMPLETA;
            this.valorTotal = this.cotizacion.getValorSinDescuento();
        }
        this.codigo = String.valueOf(System.currentTimeMillis());

        return this.codigo;
    }

    private void validarRangoDelAbono(double valorFinal, double abono) {
        if (abono > valorFinal) {
            throw new ExcepcionLongitudValor(MENSAJE_ABONO_SUPERIOR_AL_VALOR_FINAL);
        }
        if (abono < (valorFinal / MITAD)) {
            throw new ExcepcionLongitudValor(String.format(MENSAJE_ABONO_INSUFICIENTE_PARA_PRECOMPRA, valorFinal / MITAD));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public double getAbono() {
        return abono;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getEstado() {
        return estado;
    }
    public Cotizacion getCotizacion() { return cotizacion; }
}
