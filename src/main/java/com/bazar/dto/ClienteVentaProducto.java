package com.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteVentaProducto {
        private Long codigo_venta;
        private double total;
        private double cantidadProductos;
        private String nombreCliente;
        private String apellidoCliente;
}
