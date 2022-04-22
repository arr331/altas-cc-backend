package com.ceiba.configuracion;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioDetallePago;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.ServicioCrearMoto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    @Bean
    public ServicioCrearMoto servicioCrearMoto(RepositorioMoto repositorioMoto) {
        return new ServicioCrearMoto(repositorioMoto);
    }

    @Bean
    public ServicioActualizarMoto servicioActualizarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioActualizarMoto(repositorioMoto);
    }

    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra, ServicioDetallePago servicioDetallePago) {
        return new ServicioCrearCompra(repositorioCompra, servicioDetallePago);
    }

    @Bean
    public ServicioDetallePago servicioDetallePago(RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        return new ServicioDetallePago(repositorioMoto,daoMoto);
    }
}
