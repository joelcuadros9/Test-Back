package com.test.back.service;

import com.test.back.exception.ResourceNotFoundException;
import com.test.back.model.Venta;
import com.test.back.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta no existe con id :" + id));
    }

    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Boolean deleteVenta(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta no existe con id :" + id));

        ventaRepository.delete(venta);
        return true;
    }

}
