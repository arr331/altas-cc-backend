package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioCrearMoto {
    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";
    private final RepositorioMoto repositorioMoto;

    public ServicioCrearMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public Long ejecutar(Moto moto) {
        verificarExistencia(moto.getId());
        return this.repositorioMoto.crear(moto);
    }

    private void verificarExistencia(Long id) {

    }
}
