package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.service.ServicoCategory;

@RestController
@RequestMapping("/api/Category")
public class ControllerCategory {
    @Autowired
    private ServicoCategory serviceSector;

    @GetMapping()
    public List<Category> findAll(){
        return serviceSector.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id){
        return serviceSector.findById(id);
    }

    @PostMapping()
    public boolean save(@RequestBody Category sector){
        return serviceSector.save(sector);
    }

    @PostMapping("/many")
    public boolean saveAll(@RequestBody ArrayList<Category> sectors){
        return serviceSector.saveAll(sectors);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Category sector){
        return serviceSector.update(id, sector);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return serviceSector.delete(id);
    }
}
