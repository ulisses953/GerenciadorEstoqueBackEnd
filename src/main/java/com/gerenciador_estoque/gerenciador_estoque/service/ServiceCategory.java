package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ServiceInterface;
import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
@Validated
public class ServiceCategory implements ServiceInterface<Category, Long> {
    @Autowired
    private RepositoryCategory repositoryCategory;

    @Override
    public Boolean save(@Valid Category object) throws Exception {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        if (repositoryCategory.findById(object.getId()) != null) {
            throw new DataIntegrityViolationException("Category with the same ID already exists");
        }

        repositoryCategory.save(object);

        return true;
    }

    @Override
    public Boolean update(Category object) throws Exception {
        return update(object,object.getId());
    }

    @Override
    public Boolean update(@Valid Category object, Long id) throws Exception {
        if (findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with ID" + id +" not found");
        }
        if (object == null){
            throw new IllegalArgumentException("object is not null");
        }

        object.setId(id);

        repositoryCategory.save(object);

        return true;
       
    }

    @Override
    public Boolean delete(Long id) {
        if (findById(id).isEmpty()){
            return false;
        }

        repositoryCategory.deleteById(id);

        return true;
    }

    @Override
    public Optional<Category> findById(Long id)  {
        if (id == null) {
            return null;
        }

        return repositoryCategory.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repositoryCategory.findAll();
    }
    
}
