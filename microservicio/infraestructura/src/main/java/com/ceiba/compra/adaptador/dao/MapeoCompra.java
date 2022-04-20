package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idMoto = resultSet.getLong("id_moto");
        String cedula = resultSet.getString("cedula");
        String nombreCompleto = resultSet.getString("nombre_completo");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        double valorTotal = resultSet.getDouble("valor_total");
        double abono = resultSet.getDouble("abono");
        String codigo = resultSet.getString("codigo");
        String estado = resultSet.getString("estado");

        return new DtoCompra(id, idMoto, cedula, nombreCompleto, fecha, valorTotal, abono, codigo, estado);
    }
}
