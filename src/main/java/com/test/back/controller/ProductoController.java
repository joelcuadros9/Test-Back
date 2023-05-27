package com.test.back.controller;

import com.test.back.model.Producto;
import com.test.back.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @PostMapping()
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto = productoService.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping()
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        Producto updateProducto = productoService.updateProducto(producto);
        return ResponseEntity.ok(updateProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProducto(@PathVariable Long id) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", productoService.deleteProducto(id));
        return ResponseEntity.ok(response);
    }

}
