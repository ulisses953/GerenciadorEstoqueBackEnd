package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositorySector;

@Service
public class ServiceSector {
    @Autowired
    private RepositorySector repositorySector;
    
    public List<Category> findAll(){
        return (List<Category>) repositorySector.findAll();
    }

    public Category findById(long id){
        return (Category) repositorySector.findById(id).get(); 
    }

    public boolean save(Category sector){
        repositorySector.save(sector);
        return true;
    }

    public boolean saveAll(List<Category> sectors){
        repositorySector.saveAll(sectors);
        return true;
    }

    public boolean delete(long id){
        repositorySector.deleteById(id);
        return true;
    }

    public boolean update(long id, Category sector){
        sector.setId(id);
        repositorySector.save(sector);
        return true;
    }
    
}
