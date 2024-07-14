package com.bazar.service;

import com.bazar.dto.ClienteVentaProducto;
import com.bazar.model.Cliente;
import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.repository.IClienteRepository;
import com.bazar.repository.IProductoRepository;
import com.bazar.repository.IVentaRepository;
import com.bazar.serviceJPA.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository vRepo;
    @Autowired
    private IClienteRepository cRepo;
    @Autowired
    private IProductoRepository pRepo;

    //metodo para guardar una nueva venta
    @Override
    public Venta saveVenta(Venta venta) {
        return vRepo.save(venta);
    }

    //metodo para traer todas la ventas de la base de datos
    @Override
    public List<Venta> getAllVenta() {
        return vRepo.findAll();
    }

    //metodo para traer una venta especifica
    @Override
    public Venta getVenta(Long id) {
        Optional<Venta> optVenta = vRepo.findById(id);
        return optVenta.orElse(null);
    }

    //metodo para actualizar una venta espeficica. Se pide por parametro un id
    @Override
    public Venta updateVenta(Long codigo_venta, Venta ventaNueva) {
        Optional<Venta> opt = vRepo.findById(codigo_venta);
        if (opt.isPresent()){
           return vRepo.save(ventaNueva);
        }
        return null;
    }

    //metodo para eliminar una venta
    @Override
    public void deleteVenta(Long id) {
        vRepo.deleteById(id);
    }

    //metodo para traer una lista de productos de una venta especifica
    @Override
    public List<Producto> ventaProductos(Long id) {
        Optional<Venta> opt = vRepo.findById(id);
        if (opt.isPresent()){
            Venta venta = opt.get();
            List<Producto> listaProducto = venta.getListaProductos();
            return listaProducto;
        }
        return null;
    }

    //metodo para sumar la cantidad de ventas realizadas en una fecha especifica
    @Override
    public String sumatoria(LocalDate fechaVenta) {
        List<Venta> listaReducida = new ArrayList<>();
        double montoTotal= 0;
        int cantidadDeVentas= 0;

        for (Venta venta : this.getAllVenta()){
            if (venta.getFecha_venta().equals(fechaVenta)){
                listaReducida.add(venta);
                montoTotal+= venta.getTotal();
            }
        }
        cantidadDeVentas = listaReducida.size();
        return  "Cantidad de ventas: "+cantidadDeVentas + "\nMonto total: "+montoTotal;
    }

    //metodo para traer la venta mas alta, donde se mostraran ademas datos especificos del cliente
    @Override
    public ClienteVentaProducto ventaMasAlta() {
        Venta vn;
        ClienteVentaProducto cvp = new ClienteVentaProducto();
        List<Venta> listaVenta = vRepo.findAll();

        //metodo burbuja para ordenar el monto de Mayor a menor
        for (int i = 0; i < listaVenta.size() - 1; i++) {
            for (int j = 0; j < listaVenta.size() - i - 1; j++) {
                if (listaVenta.get(j).getTotal() < listaVenta.get(j + 1).getTotal()) {
                    vn = listaVenta.get(j);
                    listaVenta.set(j, listaVenta.get(j + 1));
                    listaVenta.set(j + 1, vn);
                }
            }
        }
        //una vez ordenada la lista y en caso de que no este vacia se retornara el objeto nuevo
        if (!listaVenta.isEmpty()) {
            cvp.setCodigo_venta(listaVenta.get(0).getCodigo_venta());
            cvp.setApellidoCliente(listaVenta.get(0).getUnCliente().getApellido());
            cvp.setNombreCliente(listaVenta.get(0).getUnCliente().getNombre());
            cvp.setCantidadProductos(listaVenta.get(0).getListaProductos().size());
            cvp.setTotal(listaVenta.get(0).getTotal());
            return cvp;
        }else {
            return null;
        }


    }
}
