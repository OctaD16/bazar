package com.bazar.controllerVenta;

import com.bazar.dto.ClienteVentaProducto;
import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.serviceJPA.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class VentaController {
    @Autowired
    private IVentaService vService;

    //creacion de venta
    @PostMapping("/ventas/crear")
    public Venta crearVenta(@RequestBody Venta venta){
        return vService.saveVenta(venta);
    }

    //lectura de venta
    @GetMapping("/ventas")
    public List<Venta> traerTodasVentas(){
        return vService.getAllVenta();
    }

    //lectura de venta especifica
    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta (@PathVariable (name = "codigo_venta") Long id){
        return vService.getVenta(id);
    }

    //edicion de venta
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editarVenta(@PathVariable (name = "codigo_venta") Long id,
                             @RequestBody Venta venta){
        return vService.updateVenta(id, venta);
    }

    //eliminacion de venta
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable (name = "codigo_venta") Long id){
        vService.deleteVenta(id);
    }

    //obtencion de productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> ventaProductos(@PathVariable (name = "codigo_venta") Long codigo_venta){
        return vService.ventaProductos(codigo_venta);
    }

    //Sumatoria de monto en una fecha determinada
    @GetMapping("/ventas/monto/{fecha_venta}")
    public String sumatoriaDeMonto(@PathVariable (name = "fecha_venta")LocalDate fecha_venta){
        return vService.sumatoria(fecha_venta);
    }

    //obtencion de la venta mas alta con datos especificos del cliente
    @GetMapping("/ventas/mayor_venta")
    public ClienteVentaProducto mayorVenta(){
        return vService.ventaMasAlta();
    }
}
