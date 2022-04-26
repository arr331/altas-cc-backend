package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarCompra {
    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "Lo sentimos, la compra no existe en el sistema";
    private final RepositorioCompra repositorioCompra;
    private final DaoCompra daoCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra, DaoCompra daoCompra) {
        this.repositorioCompra = repositorioCompra;
        this.daoCompra = daoCompra;
    }

    public void ejecutar(String codigo) {
        verificarExistenciaPorCodigo(codigo);
        DtoCompra dtoCompra = traerCompraPorCodigo(codigo);

        repositorioCompra.actualizar(dtoCompra.getId(), dtoCompra.getValorTotal());
    }

    private void verificarExistenciaPorCodigo(String codigo) {
        boolean existe = this.repositorioCompra.existePorCodigo(codigo);
        if(!existe) {
            throw new ExcepcionSinDatos(LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private DtoCompra traerCompraPorCodigo(String codigo) {
        return daoCompra.traerPorCodigo(codigo);
    }
}
