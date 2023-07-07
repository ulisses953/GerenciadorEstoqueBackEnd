package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceProduct;

import java.util.ArrayList;

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
    public ArrayList<Product> getAll(){
        return serviceProduct.getAll();
    }
    
    @PostMapping()
    public boolean addProducts(@RequestBody Product products){
        return serviceProduct.addProduct(products);
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
