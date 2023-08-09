package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ServiceInterface;
import com.gerenciador_estoque.gerenciador_estoque.model.ClientDelivery;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryClientDelivery;

@Service
public class ServiceClientDelivery implements ServiceInterface<ClientDelivery> {
    @Autowired
    private RepositoryClientDelivery repository;

    @Override
    public boolean save(ClientDelivery object) {
        repository.save(object);
        return true;
    }

    @Override
    public List<ClientDelivery> findAll() {
       return (List<ClientDelivery>) repository.findAll();
    }

    @Override
    public ClientDelivery findById(long id) {
       return (ClientDelivery)  repository.findById(id).get();
    }

    @Override
    public boolean saveAll(List<ClientDelivery> objects) { 
      repository.saveAll(objects);
      return true;
    }

    @Override
    public boolean update(long id, ClientDelivery object) {
        object.setId(id);
        repository.save(object);
        return true;
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }
    
}
