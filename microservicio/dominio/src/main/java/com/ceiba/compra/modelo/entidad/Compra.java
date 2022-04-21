package com.ceiba.compra.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Compra {
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
