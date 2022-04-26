package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDateTime;

public class ComandoCompraTestDataBuilder {
    private Long id;
    private Long idMoto;
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;

    public ComandoCompraTestDataBuilder() {
        this.id = null;
        this.idMoto = 1L;
        this.cedula = "1040048300";
        this.nombreCompleto = "Adrian Ramírez";
        this.valorTotal = 22050;
        this.abono = 22050;
        this.codigo = "2022-1";
        this.estado = "C";
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, idMoto, cedula, nombreCompleto, fecha, valorTotal, abono, codigo, estado);
    }
}
