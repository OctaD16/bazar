package com.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

    @ManyToMany(mappedBy = "listaProductos", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
}
