package com.bazar.service;

import com.bazar.model.Venta;
import com.bazar.repository.IVentaRepository;
import com.bazar.serviceJPA.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository vRepo;
    @Override
    public Venta saveVenta(Venta venta) {
        return vRepo.save(venta);
    }

    @Override
    public List<Venta> getAllVenta() {
        return vRepo.findAll();
    }

    @Override
    public Venta getVenta(Long id) {
        Optional<Venta> optVenta = vRepo.findById(id);
        return optVenta.orElse(null);
    }

    @Override
    public Venta updateVenta(Long codigo_venta, Venta ventaNueva) {
        Optional<Venta> opt = vRepo.findById(codigo_venta);
        if (opt.isPresent()){
           return vRepo.save(ventaNueva);
        }
        return null;
    }

    @Override
    public void deleteVenta(Long id) {
        vRepo.deleteById(id);
    }
}
