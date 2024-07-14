package com.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "venta_producto",
            joinColumns = {@JoinColumn(name = "venta_id", referencedColumnName = "codigo_venta")},
            inverseJoinColumns = {@JoinColumn(name = "producto_id", referencedColumnName = "codigo_producto")})
    private List<Producto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;
}
