package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.dto.DtoInformacionCompra;

import java.util.List;

public interface DaoCompra {
    List<DtoCompra> listar();
    DtoCompra traerPorId(Long id);
//    DtoInformacionCompra informacionCompra();
}
