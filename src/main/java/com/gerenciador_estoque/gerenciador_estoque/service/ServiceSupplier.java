package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Supplier;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositorySupplier;

@Service
public class ServiceSupplier {
    @Autowired
    private RepositorySupplier repositorySupplier;

    public ArrayList<Supplier> findAll(){
        return (ArrayList<Supplier>) repositorySupplier.findAll();
    }

    public Supplier findAllById(Integer id){
        return repositorySupplier.findById(id).get();
    }
    
    public boolean save(Supplier supplier){
        repositorySupplier.save(supplier);
        return true;
    }

    public boolean update(int id, Supplier supplier){
        supplier.getId();
        repositorySupplier.save(supplier);
        return true;
    }

    public boolean delete(int id){
        repositorySupplier.deleteById(id);
        return true;
    }

    public boolean saveAll(ArrayList<Supplier> suppliers){
        repositorySupplier.saveAll(suppliers);
        return true;
    }
}
