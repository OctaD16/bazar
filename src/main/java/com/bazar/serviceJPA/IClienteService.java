package com.bazar.serviceJPA;

import com.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {
    //metodo de creacion
    public Cliente saveCliente(Cliente cliente);

    //metodo de lectura
    public List<Cliente> getAllClientes();

    //metodo de lectura especifica
    public Cliente getCliente(Long id);

    //metodo de actualizacion de cliente
    public Cliente updateCliente(Long id, Cliente cliente);

    //metodo de eliminacion de cliente
    public void deleteCliente(Long id);
}
