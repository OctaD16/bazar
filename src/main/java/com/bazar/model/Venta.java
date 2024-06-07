package com.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;

    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="venta_producto",
                joinColumns = {@JoinColumn(name="venta_id")},
                inverseJoinColumns = {@JoinColumn(name = "producto_id")})

    private List<Producto> listaProductos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;
}
