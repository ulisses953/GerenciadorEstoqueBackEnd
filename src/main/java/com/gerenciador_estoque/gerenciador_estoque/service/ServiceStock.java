package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ServiceInterface;
import com.gerenciador_estoque.gerenciador_estoque.model.Stock;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStock implements ServiceInterface<Stock>{
    
    @Autowired
    private RepositoryStock repositoryStock;

    @Override
    public boolean save(Stock object) {
        repositoryStock.save(object);
        return true;
    }

    @Override
    public ArrayList<Stock> findAll() {
        return (ArrayList<Stock>) repositoryStock.findAll();
    }


    @Override
    public boolean saveAll(ArrayList<Stock> objects) {
        repositoryStock.saveAll(objects);
        return true;
    }

    @Override
    public boolean update(long id, Stock object) {
        object.setId(id);
        return save(object);
    }

    @Override
    public boolean delete(long id) {
        repositoryStock.deleteById(id);
        return true;
    }

    @Override
    public Stock findById(long id) {
        return repositoryStock.findById(id).get();
    }


}
