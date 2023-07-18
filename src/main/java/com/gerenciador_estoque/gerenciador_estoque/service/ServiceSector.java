package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Sector;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositorySector;

@Repository
public class ServiceSector {
    @Autowired
    private RepositorySector repositorySector;
    
    public ArrayList<Sector> findAll(){
        return (ArrayList<Sector>) repositorySector.findAll();
    }

    public Sector findById(long id){
        return (Sector) repositorySector.findById(id).get(); 
    }

    public boolean save(Sector sector){
        repositorySector.save(sector);
        return true;
    }

    public boolean saveAll(List<Sector> sectors){
        repositorySector.saveAll(sectors);
        return true;
    }

    public boolean delete(long id){
        repositorySector.deleteById(id);
        return true;
    }

    public boolean update(long id, Sector sector){
        sector.setId(id);
        repositorySector.save(sector);
        return true;
    }
    
}
