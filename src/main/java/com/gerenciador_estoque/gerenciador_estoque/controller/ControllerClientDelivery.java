package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gerenciador_estoque.gerenciador_estoque.model.ClientDelivery;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceClientDelivery;

@RestController
@RequestMapping("api/Client/Delivery")
public class ControllerClientDelivery {
    @Autowired
    private ServiceClientDelivery service;

    @PostMapping()
    public boolean save(@RequestBody ClientDelivery object) {
        return service.save(object);
    }

    @GetMapping()
    public List<ClientDelivery> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClientDelivery findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping("/many")
    public boolean saveAll(@RequestBody List<ClientDelivery> objects) {
        return service.saveAll(objects);
    }

    @PutMapping
    public boolean update(long id, ClientDelivery object) {
        return service.update(id, object);
    }

    @DeleteMapping
    public boolean delete(long id) {
        return service.delete(id);
    }

}
