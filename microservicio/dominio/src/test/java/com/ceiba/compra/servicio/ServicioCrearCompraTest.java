package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearCompraTest {
    private static final double VALOR_FINAL = 21000;
    private static final String ESTADO_COMPLETO = "C";
    private static final String ESTADO_INCOMPLETO = "I";

    @Test
    @DisplayName("Validar que el abono esté en el rango permitido")
    void validarAbonoNoSupereValorFinal() {
//        // Arrange
//        Compra compra = new CompraTestBuilder().conAbono(22100).build();
//        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
//        ServicioCotizacion servicioCotizacion = Mockito.mock(ServicioCotizacion.class);
//        Mockito.when(servicioCotizacion.ejecutar(Mockito.anyLong())).thenReturn(new DetallePagoTestBuilder().conValorFinal(22000).build());
//        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, servicioCotizacion);
//
//        // Act - Assert
//        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionLongitudValor.class,
//                "El valor a pagar no puede superar el valor de pago final");
    }

    @Test
    @DisplayName("Validar que el abono no sea inferior a la mitad del valor final")
    void validarAbonoNoSeaInferiorALaMitadDelValorFinal() {
        // Arrange
//        Compra compra = new CompraTestBuilder().conAbono(10000).build();
//        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
//        ServicioCotizacion servicioCotizacion = Mockito.mock(ServicioCotizacion.class);
//        Mockito.when(servicioCotizacion.ejecutar(Mockito.anyLong())).
//                thenReturn(new DetallePagoTestBuilder().conValorFinal(VALOR_FINAL).build());
//        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, servicioCotizacion);
//
//        // Act - Assert
//        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionLongitudValor.class,
//                String.format("El valor a pagar debe ser mínimo la mitad  del valor de pago final, Valor mínimo: $%s", VALOR_FINAL / 2));
    }

    @Test
    @DisplayName("Validar que el estado de la compra sea completa")
    void validarCompraConEstadoCompleta() {
        // Arrange
//        Compra compra = new CompraTestBuilder().conAbono(12000).build();
//        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
//        ServicioCotizacion servicioCotizacion = Mockito.mock(ServicioCotizacion.class);
//        Mockito.when(servicioCotizacion.ejecutar(Mockito.anyLong())).
//                thenReturn(new DetallePagoTestBuilder().conValorFinal(12000).build());
//        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, servicioCotizacion);
//        // Act
//        servicioCrearCompra.ejecutar(compra);
//        // Assert
//        assertEquals(ESTADO_COMPLETO, compra.getEstado());
    }

    @Test
    @DisplayName("Validar que el estado de la compra sea incompleta")
    void validarCompraConEstadoIncompleta() {
        // Arrange
//        Compra compra = new CompraTestBuilder().conAbono(8000).build();
//        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
//        ServicioCotizacion servicioCotizacion = Mockito.mock(ServicioCotizacion.class);
//        Mockito.when(servicioCotizacion.ejecutar(Mockito.anyLong())).
//                thenReturn(new DetallePagoTestBuilder().conValorFinal(12000).build());
//        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, servicioCotizacion);
//        // Act
//        servicioCrearCompra.ejecutar(compra);
//        // Assert
//        assertEquals(ESTADO_INCOMPLETO, compra.getEstado());
    }
}
