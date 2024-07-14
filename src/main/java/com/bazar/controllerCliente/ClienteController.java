package com.bazar.controllerCliente;

import com.bazar.model.Cliente;
import com.bazar.serviceJPA.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService cService;

    //metodo de alta de cliente
    @PostMapping("/clientes/crear")
    public Cliente crear(@RequestBody Cliente cliente){
    return cService.saveCliente(cliente);
    }

    //metodo de lectura de cliente
    @GetMapping("/clientes")
    public List<Cliente> traerTodos(){
        return cService.getAllClientes();
    }

    //metodo de lectura de un solo cliente
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable (name = "id_cliente") Long id){
        return cService.getCliente(id);
    }

    //metodo de actualizacion de cliente
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editarCliente(@PathVariable (name = "id_cliente") Long id,
                                 @RequestBody Cliente clienteNuevo){
        return cService.updateCliente(id, clienteNuevo);
    }

    //metodo de eliminacion de cliente
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable (name = "id_cliente") Long id){
        cService.deleteCliente(id);
    }
}
