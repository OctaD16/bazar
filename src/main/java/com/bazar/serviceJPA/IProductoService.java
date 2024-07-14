package com.bazar.serviceJPA;

import com.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
    //metodo de creacion de producto
    public Producto saveProducto(Producto producto);

    //metodo de lectura
    public List<Producto> getAllProductos();

    //metodo de lectura especifica
    public Producto getProducto(Long id);

    //metodo de actualizacion de producto
    public Producto updateProducto(Long id, Producto producto);

    //metodo de eliminacion
    public  void deleteProducto(Long id);

    //Disponibilidad de Productos menores a 5
    List<Producto> productoDisponible();
}
