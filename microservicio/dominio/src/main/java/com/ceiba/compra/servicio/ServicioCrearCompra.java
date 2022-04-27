package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.modelo.entidad.Cotizacion;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;

public class ServicioCrearCompra {
    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public String ejecutar(Cotizacion cotizacion, String cedula, String nombreCompleto, double abono) {

        Compra compra = Compra.of(1L, cotizacion, cedula, nombreCompleto, abono);
        String codigo = compra.abonar();
        repositorioCompra.crear(compra);

        return codigo;
    }


}
