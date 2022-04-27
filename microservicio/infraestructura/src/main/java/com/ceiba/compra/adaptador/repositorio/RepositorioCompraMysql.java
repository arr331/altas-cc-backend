package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.dto.DtoActualizarCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {
    private static final String ESTADO_COMPLETO = "C";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="compra", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="compra", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="compra", value="existePorCodigo")
    private static String sqlExistePorCodigo;

    public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compra compra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", null);
        paramSource.addValue("id_moto", compra.getCotizacion().getMoto().getId());
        paramSource.addValue("cedula", compra.getCedula());
        paramSource.addValue("nombre_completo", compra.getNombreCompleto());
        paramSource.addValue("fecha", compra.getFecha());
        paramSource.addValue("valor_total", compra.getValorTotal());
        paramSource.addValue("abono", compra.getAbono());
        paramSource.addValue("codigo", compra.getCodigo());
        paramSource.addValue("estado", compra.getEstado());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
//        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().execute(sqlCrear, paramSource);
    }

    @Override
    public void actualizar(Long id, double abono) {
        DtoActualizarCompra actualizarCompra = new DtoActualizarCompra(id, abono, ESTADO_COMPLETO);
        this.customNamedParameterJdbcTemplate.actualizar(actualizarCompra, sqlActualizar);
    }

    @Override
    public boolean existePorCodigo(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorCodigo, paramSource, Boolean.class);
    }
}
