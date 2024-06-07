package com.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @ManyToMany(mappedBy = "listaProductos")
    private List<Venta> ventaList = new ArrayList<>();




}
