package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public class CompraTestBuilder {
    private Long id;
    private Long idMoto;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;

    public CompraTestBuilder() {
        this.id = 1L;
        this.idMoto = 1L;
        this.cedula = "1040048300";
        this.nombreCompleto = "Adrian Ramírez";
        this.valorTotal = 22050;
        this.abono = 22050;
        this.codigo = "2021-1";
        this.estado = "C";
    }

    public CompraTestBuilder conIdMoto(Long idMoto) {
        this.idMoto = idMoto;
        return this;
    }

    public CompraTestBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public CompraTestBuilder conNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public CompraTestBuilder conAbono(double abono) {
        this.abono = abono;
        return this;
    }

    public Compra build() { return Compra.of(id, idMoto, cedula, nombreCompleto, fecha, valorTotal, abono, codigo, estado); }
}
