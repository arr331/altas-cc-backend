package com.ceiba.compra.comando;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ComandoCompra {
    private Long id;
    private Long idMoto;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;

    public ComandoCompra(Long id, Long idMoto, String cedula, String nombreCompleto, LocalDateTime fecha, double valorTotal, double abono, String codigo, String estado) {
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
