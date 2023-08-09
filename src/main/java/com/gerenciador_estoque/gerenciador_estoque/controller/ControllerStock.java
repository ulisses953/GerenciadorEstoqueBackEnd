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

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ControllerInterfece;
import com.gerenciador_estoque.gerenciador_estoque.model.Stock;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceStock;


@RestController
@RequestMapping("api/stock")
public class ControllerStock implements ControllerInterfece<Stock>{
    @Autowired
    ServiceStock serviceStock;

    @PostMapping
    public boolean save(@RequestBody Stock object) {
        return serviceStock.save(object);
    }

    @GetMapping
    public List<Stock> findAll() {
       return serviceStock.findAll();
    }

    @GetMapping("/{id}")
    public Stock findById(@PathVariable long id) {
        return serviceStock.findById(id);
    }

    @PostMapping("/many")
    public boolean saveAll(@RequestBody List<Stock> objects) {
        return serviceStock.saveAll(objects);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id,@RequestBody Stock object) {
        return serviceStock.update(id,object);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return serviceStock.delete(id);
    }

}
