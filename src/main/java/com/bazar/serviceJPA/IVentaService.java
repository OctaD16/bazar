package com.bazar.serviceJPA;

import com.bazar.model.Venta;

import java.util.List;

public interface IVentaService {
    //metodo para crear una venta
    public Venta saveVenta(Venta venta);

    //metodo de lectura
    public List<Venta> getAllVenta();

    //metodo de lectura especifica
    public Venta getVenta(Long id);

    //metodo de edicion de venta
    public Venta updateVenta (Long id, Venta venta);

    //metodo de eliminacion de venta
    public void deleteVenta(Long id);

}
