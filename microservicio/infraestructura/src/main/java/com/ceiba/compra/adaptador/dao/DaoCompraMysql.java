package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoCompraMysql implements DaoCompra {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="compra", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="compra", value="traerPorCodigo")
    private static String sqlTraerPorCodigo;

    public DaoCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCompra());
    }

    @Override
    public DtoCompra traerPorCodigo(String codigo) {
        Map<String, String> parametro = new HashMap<>();
        parametro.put("codigo", codigo);
        System.out.println(codigo + "JADJSJDJSJ");
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlTraerPorCodigo, parametro, new MapeoCompra());
    }

}
