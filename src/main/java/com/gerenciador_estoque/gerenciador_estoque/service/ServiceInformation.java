package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gerenciador_estoque.gerenciador_estoque.error.NotFoundException;
import com.gerenciador_estoque.gerenciador_estoque.interfaces.ServiceInterface;
import com.gerenciador_estoque.gerenciador_estoque.model.Information;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryInformation;

public class ServiceInformation implements ServiceInterface<Information>{
    @Autowired
    protected RepositoryInformation repositoryInformation;


    @Override
    public boolean save(Information object) {
        repositoryInformation.save(object);
        return true;
    }

    @Override
    public List<Information> findAll() {
        return repositoryInformation.findAll();
    }

    @Override
    public Information findById(long id) {
        return repositoryInformation.findById(id).orElseThrow(() -> new NotFoundException("information id not found :"+ id ));
    }

    @Override
    public boolean saveAll(List<Information> objects) {
        repositoryInformation.saveAll(objects);
        return true;
    }

    @Override
    public boolean update(long id, Information object) {
        object.setId(id);
        repositoryInformation.save(object);
        return true;
    }

    @Override
    public boolean delete(long id) {
        repositoryInformation.deleteById(id);
        return true;
    }
    
}
