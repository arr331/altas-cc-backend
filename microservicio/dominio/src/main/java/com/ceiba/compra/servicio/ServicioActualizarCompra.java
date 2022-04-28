package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarCompra {
    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "Lo sentimos, no se encrontro una compra pendiente con este codigo";
    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(String codigo) {
        verificarCompraIncompletaPorCodigo(codigo);
        repositorioCompra.actualizar(codigo);
    }

    private void verificarCompraIncompletaPorCodigo(String codigo) {
        boolean existe = this.repositorioCompra.existeCompraIncompletaPorCodigo(codigo);
        if(!existe) {
            throw new ExcepcionSinDatos(LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
