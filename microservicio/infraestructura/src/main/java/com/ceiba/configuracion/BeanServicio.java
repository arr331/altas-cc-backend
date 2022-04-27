package com.ceiba.configuracion;

import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioCotizacion;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.ServicioCrearMoto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
	
    @Bean
    public ServicioCrearMoto servicioCrearMoto(RepositorioMoto repositorioMoto) {
        return new ServicioCrearMoto(repositorioMoto);
    }

    @Bean
    public ServicioActualizarMoto servicioActualizarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioActualizarMoto(repositorioMoto);
    }

    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra) {
        return new ServicioCrearCompra(repositorioCompra);
    }

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra, DaoCompra daoCompra) {
        return new ServicioActualizarCompra(repositorioCompra, daoCompra);
    }

    @Bean
    public ServicioCotizacion servicioDetallePago() {
        return new ServicioCotizacion();
    }
}
