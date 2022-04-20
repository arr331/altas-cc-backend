package com.ceiba.moto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMoto implements RowMapper<DtoMoto>, MapperResult {

    @Override
    public DtoMoto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        double precio = resultSet.getDouble("precio");
        int cc = resultSet.getInt("cc");
        String marca = resultSet.getString("marca");
        String estado = resultSet.getString("estado");
        int descuento = resultSet.getInt("descuento");
        String nombreImagen = resultSet.getString("nombre_imagen");
        String nombreMoto = resultSet.getString("nombre_moto");

        return new DtoMoto(id, precio, cc, marca, estado, descuento, nombreImagen, nombreMoto);
    }

}
