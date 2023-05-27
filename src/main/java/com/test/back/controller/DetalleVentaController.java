package com.test.back.controller;

import com.test.back.model.DetalleVenta;
import com.test.back.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/detalles-ventas")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping()
    public List<DetalleVenta> getAllDetallesVentas() {
        return detalleVentaService.getAllDetallesVentas();
    }

    @PostMapping()
    public DetalleVenta createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.createDetalleVenta(detalleVenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getDetalleVentaById(@PathVariable Long id) {
        DetalleVenta detalleVenta = detalleVentaService.getDetalleVentaById(id);
        return ResponseEntity.ok(detalleVenta);
    }

    @PutMapping()
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta updateDetalleVenta = detalleVentaService.updateDetalleVenta(detalleVenta);
        return ResponseEntity.ok(updateDetalleVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDetalleVenta(@PathVariable Long id) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", detalleVentaService.deleteDetalleVenta(id));
        return ResponseEntity.ok(response);
    }

}
