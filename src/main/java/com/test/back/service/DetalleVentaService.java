package com.test.back.service;

import com.test.back.exception.ResourceNotFoundException;
import com.test.back.model.DetalleVenta;
import com.test.back.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> getAllDetallesVentas() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta getDetalleVentaById(Long id) {
        return detalleVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleVenta no existe con id :" + id));
    }

    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public Boolean deleteDetalleVenta(Long id) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleVenta no existe con id :" + id));

        detalleVentaRepository.delete(detalleVenta);
        return true;
    }

}
