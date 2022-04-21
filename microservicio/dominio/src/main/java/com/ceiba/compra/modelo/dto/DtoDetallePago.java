package com.ceiba.compra.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoDetallePago {
    private double valorSinDescuento;
    private double valorFinal;
    private double impuesto; // 2%
    private double descuentoLunes; // 1.5%
    private double descuentoFinDeSemana; // 1%

    public DtoDetallePago() {
    }
}
