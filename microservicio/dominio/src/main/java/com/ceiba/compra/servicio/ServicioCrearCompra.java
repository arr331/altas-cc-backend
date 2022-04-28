package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;

public class ServicioCrearCompra {
    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public String ejecutar(Compra compra) {
        compra.abonar();
        repositorioCompra.crear(compra);
        return compra.getCodigo();
    }
}
