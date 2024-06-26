package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.repository.IProductoRepository;
import com.bazar.serviceJPA.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository pRepo;

    @Override
    public Producto saveProducto(Producto producto) {
        return pRepo.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return pRepo.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        Optional<Producto> optProd = pRepo.findById(id);
        return optProd.orElse(null);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        Optional<Producto> opt = pRepo.findById(id);
        if (opt.isPresent()){
            return pRepo.save(producto);
        }
        return null;
    }

    @Override
    public void deleteProducto(Long id) {
        pRepo.deleteById(id);
    }

    @Override
    public List<Producto> productoDisponible() {
        List<Producto> listaCompleta = this.getAllProductos();

        //aquellos productos cuya cantidad sea menor a 5 seran incluidos en esta nueva lista
        List<Producto> listaReducida = new ArrayList<>();
        for (Producto prod : listaCompleta){
            if (prod.getCantidad_disponible()<=5){
                listaReducida.add(prod);
            }
        }
        return listaReducida;
    }
}
