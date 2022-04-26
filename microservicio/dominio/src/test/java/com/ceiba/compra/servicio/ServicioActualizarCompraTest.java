package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ServicioActualizarCompraTest {
    private static final double VALOR_TOTAL = 21000;
    private static final double VALOR_ABONO = 21000;
    private static final Long ID = 3L;
    private static final String ESTADO_COMPLETO = "C";
    private static final String ESTADO_INCOMPLETO = "I";
    private static final String CODIGO_COMPRA_NO_EXISTE = "2022-4";
    private static final String CODIGO_COMPRA_EXISTE = "2022-3";

    @Test
    @DisplayName("Debería validar que la compra no exista")
    void verificarQueNoExistaLaCompra() {
        // Arrange
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
        Mockito.when(repositorioCompra.existePorCodigo(CODIGO_COMPRA_NO_EXISTE)).thenReturn(false);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra, daoCompra);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(CODIGO_COMPRA_NO_EXISTE), ExcepcionSinDatos.class,
                "Lo sentimos, la compra no existe en el sistema");
    }

    @Test
    @DisplayName("Validar que la compra se actualice correctamente")
    public void verificarQueSeActualiceLaCompra() {
        // Arrange

        DtoCompra dtoCompra = new CompraTestBuilder().conId(ID).conValorTotal(VALOR_TOTAL).conAbono(VALOR_ABONO).buildDto();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCompra daoCompra = Mockito.mock(DaoCompra.class);

        Mockito.when(repositorioCompra.existePorCodigo(Mockito.anyString())).thenReturn(true);
        Mockito.when(daoCompra.traerPorCodigo(CODIGO_COMPRA_EXISTE)).thenReturn(dtoCompra);

        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra, daoCompra);
        // Act
        servicioActualizarCompra.ejecutar(CODIGO_COMPRA_EXISTE);
        // Assert
        verify(repositorioCompra, times(1)).actualizar(ID, VALOR_ABONO);
    }

}
