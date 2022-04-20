package com.ceiba.moto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMotoMysql implements RepositorioMoto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="moto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="moto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="moto", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioMotoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Moto moto) {
        return this.customNamedParameterJdbcTemplate.crear(moto, sqlCrear);
    }

    @Override
    public void actualizar(Moto moto) {
        this.customNamedParameterJdbcTemplate.actualizar(moto, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
