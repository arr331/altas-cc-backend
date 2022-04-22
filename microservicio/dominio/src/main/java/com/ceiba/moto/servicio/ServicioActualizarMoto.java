package com.ceiba.moto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioActualizarMoto {
    private static final String LA_MOTO_NO_EXISTE_EN_EL_SISTEMA = "La moto no existe en el sistema";
    private final RepositorioMoto repositorioMoto;

    public ServicioActualizarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public void ejecutar(Moto moto) {
        verificarExistencia(moto.getId());
        this.repositorioMoto.actualizar(moto);
    }

    private void verificarExistencia(Long id) {
        boolean existe = this.repositorioMoto.existePorId(id);
        if(!existe) {
            throw new ExcepcionSinDatos(LA_MOTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
