package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerenciador_estoque.gerenciador_estoque.model.Supplier;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceSupplier;

@Controller
@RequestMapping("/api/supplier")
public class ControllerSupplier {
    
    @Autowired
    private ServiceSupplier serviceSupplier; 
    
    @GetMapping
    public ArrayList<Supplier> findAll(){
        return serviceSupplier.findAll();
    }

    @PostMapping
    public boolean save(@RequestBody Supplier supplier){
        return serviceSupplier.save(supplier);
    }
    @PostMapping("/anny")
    public boolean saveAll(@RequestBody ArrayList<Supplier> suppliers){
        return serviceSupplier.saveAll(suppliers);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Supplier supplier){
        return serviceSupplier.update(id, supplier);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return serviceSupplier.delete(id);
    }
}
