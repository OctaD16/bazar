package com.bazar.controllerVenta;

import com.bazar.model.Venta;
import com.bazar.serviceJPA.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService vService;

    //creacion de venta
    @PostMapping("/venta/crear")
    public Venta crearVenta(@RequestBody Venta venta){
        return vService.saveVenta(venta);
    }

    //lectura de venta
    @GetMapping("/ventas")
    public List<Venta> traerTodasVentas(){
        return vService.getAllVenta();
    }

    //lectura de venta especifica
    @GetMapping("/venta/{codigo_venta}")
    public Venta traerVenta (@PathVariable (name = "codigo_venta") Long id){
        return vService.getVenta(id);
    }

    //edicion de venta
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editarVenta(@PathVariable (name = "codigo_venta") Long id, Venta venta){
        return vService.updateVenta(id, venta);
    }

    //eliminacion de venta
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable (name = "codigo_venta") Long id){
        vService.deleteVenta(id);
    }

}
