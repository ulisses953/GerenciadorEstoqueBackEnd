package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceProduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/product")
public class ControllerProduto {

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping
    public List<Product> findAll() {
        return serviceProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) {
        return serviceProduct.findById(id);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Product products) {
        serviceProduct.save(products);
        return ResponseEntity.ok("");
    }
    @PostMapping("/many")
    public ResponseEntity<?> addProducts(@RequestBody ArrayList<Product> products) { 
        serviceProduct.addProducts(products);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  delete(@PathVariable int id) {
        serviceProduct.delete(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?>  update(@PathVariable int id, @RequestBody Product product) {
        serviceProduct.update(id, product);
        return ResponseEntity.ok("");
    }

}