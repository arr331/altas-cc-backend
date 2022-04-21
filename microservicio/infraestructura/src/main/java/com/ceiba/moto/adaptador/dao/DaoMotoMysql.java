package com.ceiba.moto.adaptador.dao;

import com.ceiba.compra.adaptador.dao.MapeoCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoMotoMysql implements DaoMoto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="moto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="moto", value="traerPorId")
    private static String sqlTraerPorId;

    public DaoMotoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMoto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMoto());
    }

    @Override
    public DtoMoto traerPorId(Long id) {
        Map<String, Long> parametro = new HashMap<>();
        parametro.put("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlTraerPorId, parametro, new MapeoMoto());
    }
}
