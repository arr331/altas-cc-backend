package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.moto.modelo.entidad.Moto;

import java.time.LocalDateTime;

public class CompraTestBuilder {
    private String cedula;
    private String nombreCompleto;
    private LocalDateTime fecha;
    private double valorTotal;
    private double abono;
    private String codigo;
    private String estado;
    private Cotizacion cotizacion;

    public CompraTestBuilder() {
        this.cotizacion = new CotizacionTestBuilder().build();
        this.cedula = "1040048300";
        this.nombreCompleto = "Adrian Ramírez";
        this.valorTotal = this.cotizacion.getValorFinal();
        this.abono = this.cotizacion.getValorFinal();
        this.codigo = "2021-1";
        this.estado = "C";
    }

    public CompraTestBuilder conCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
        return this;
    }

    public CompraTestBuilder conNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public CompraTestBuilder conValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public CompraTestBuilder conAbono(double abono) {
        this.abono = abono;
        return this;
    }

//    public DtoCompra buildDto() { return new DtoCompra(id, idMoto, cedula, nombreCompleto, fecha, valorTotal, abono, codigo, estado); }


    public Compra build() { return Compra.of(this.cotizacion, this.cedula, this.nombreCompleto, this.abono); }
}
