package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceProduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> findAll(){
        return serviceProduct.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id){
        return serviceProduct.findById(id);
    }
    
    @PostMapping()
    public boolean save(@RequestBody Product products){
        return serviceProduct.save(products);
    }

    @PostMapping("/many")
    public boolean addProducts(@RequestBody ArrayList<Product> products){
        return serviceProduct.addProducts(products);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return serviceProduct.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable int id,@RequestBody Product product){
        return serviceProduct.update(id,product);
    }
   
}