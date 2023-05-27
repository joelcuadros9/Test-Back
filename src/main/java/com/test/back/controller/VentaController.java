package com.test.back.controller;

import com.test.back.model.Venta;
import com.test.back.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping()
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @PostMapping()
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.createVenta(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Venta venta = ventaService.getVentaById(id);
        return ResponseEntity.ok(venta);
    }

    @PutMapping()
    public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
        Venta updateVenta = ventaService.updateVenta(venta);
        return ResponseEntity.ok(updateVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVenta(@PathVariable Long id) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", ventaService.deleteVenta(id));
        return ResponseEntity.ok(response);
    }

}
