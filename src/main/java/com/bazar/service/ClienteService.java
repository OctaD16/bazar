package com.bazar.service;

import com.bazar.model.Cliente;
import com.bazar.repository.IClienteRepository;
import com.bazar.serviceJPA.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository cRepo;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return cRepo.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return cRepo.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        Optional<Cliente> cliente = cRepo.findById(id);
        return cliente.orElse(null); // Manejo del Optional
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteNuevo) {
        Optional<Cliente> opt = cRepo.findById(id);
        if (opt.isPresent()){
            return cRepo.save(clienteNuevo);
        }
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        cRepo.deleteById(id);
    }
}
