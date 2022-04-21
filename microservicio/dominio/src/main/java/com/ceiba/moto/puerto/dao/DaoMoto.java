package com.ceiba.moto.puerto.dao;

import com.ceiba.moto.modelo.dto.DtoMoto;

import java.util.List;

public interface DaoMoto {
    List<DtoMoto> listar();
    DtoMoto traerPorId(Long id);
}
