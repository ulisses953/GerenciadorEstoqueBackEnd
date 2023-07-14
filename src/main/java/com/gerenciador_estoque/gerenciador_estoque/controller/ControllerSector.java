package com.gerenciador_estoque.gerenciador_estoque.controller;

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

import com.gerenciador_estoque.gerenciador_estoque.model.Sector;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceSector;

@RestController
@RequestMapping("/api/Sector")
public class ControllerSector {
    @Autowired
    private ServiceSector serviceSector;

    @GetMapping()
    public List<Sector> findAll(){
        return serviceSector.findAll();
    }

    @GetMapping("/{id}")
    public Sector findById(@PathVariable Integer id){
        return serviceSector.findById(id);
    }

    @PostMapping()
    public boolean save(@RequestBody Sector sector){
        return serviceSector.save(sector);
    }

    @PostMapping("/many")
    public boolean saveAll(@RequestBody List<Sector> sectors){
        return serviceSector.saveAll(sectors);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Sector sector){
        return serviceSector.update(id, sector);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return serviceSector.delete(id);
    }
    
}
