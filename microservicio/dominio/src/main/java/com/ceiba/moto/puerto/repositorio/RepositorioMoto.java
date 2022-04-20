package com.ceiba.moto.puerto.repositorio;

import com.ceiba.moto.modelo.entidad.Moto;

public interface RepositorioMoto {
    Long crear(Moto moto);
    void actualizar(Moto moto);
    boolean existePorId(Long id);
}
