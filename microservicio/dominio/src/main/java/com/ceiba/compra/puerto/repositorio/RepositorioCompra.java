package com.ceiba.compra.puerto.repositorio;


import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {
    Long crear(Compra compra);
    void actualizar(Compra compra);
    boolean existePorId(Long id);
}
