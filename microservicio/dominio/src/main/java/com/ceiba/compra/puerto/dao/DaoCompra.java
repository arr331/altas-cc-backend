package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;

import java.util.List;

public interface DaoCompra {
    List<DtoCompra> listar();
    DtoCompra traerPorId(Long id);
}
