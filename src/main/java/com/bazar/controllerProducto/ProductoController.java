package com.bazar.controllerProducto;

import com.bazar.model.Producto;
import com.bazar.serviceJPA.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService pService;

    //alta de producto
    @PostMapping("/productos/crear")
    public Producto crearProducto(@RequestBody Producto producto){
        return pService.saveProducto(producto);
    }

    //lectura de productos
    @GetMapping("/productos")
    public List<Producto> traerTodosProductos(){
        return pService.getAllProductos();
    }

    //lectura de producto especifico
    @GetMapping("/productos/{id_producto}")
    public Producto traerProducto(@PathVariable (name = "id_producto") Long id){
        return pService.getProducto(id);
    }

    //edicion de producto
    @PutMapping("/productos/editar/{id_producto}")
    public Producto editarProducto(@PathVariable (name = "id_producto") Long id,
                                   @RequestBody Producto producto){
        return pService.updateProducto(id, producto);
    }

    //eliminacion de producto
    @DeleteMapping("/productos/eliminar/{id_producto}")
    public void eliminarProducto(@PathVariable (name = "id_producto") Long id_producto){
        pService.deleteProducto(id_producto);
    }

    //Disponibilidad de Productos menores a 5
    @GetMapping("/productos/falta_stock")
    public List<Producto> listaProducto(){
        return pService.productoDisponible();
    }
}
