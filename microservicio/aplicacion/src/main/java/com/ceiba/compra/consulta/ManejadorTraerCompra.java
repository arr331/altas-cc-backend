package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorTraerCompra {
    private final DaoCompra daoCompra;

    public ManejadorTraerCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    public DtoCompra ejecutar(Long id) {
        return this.daoCompra.traerPorId(id);
    }
}
