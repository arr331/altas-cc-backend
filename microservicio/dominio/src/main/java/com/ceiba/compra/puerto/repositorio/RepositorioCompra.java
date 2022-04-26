package com.ceiba.compra.puerto.repositorio;


import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {
    Long crear(Compra compra);
    void actualizar(Long id, double abono);
    boolean existePorCodigo(String codigo);
}
