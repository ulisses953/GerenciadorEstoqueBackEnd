package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

import jakarta.persistence.EntityNotFoundException;

@Service
@Validated
public class ServiceCategory {
    @Autowired
    private RepositoryCategory repositoryCategory;

    
    public Boolean save( Category object) throws Exception {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        repositoryCategory.save(object);

        return true;
    }

    public Boolean update(Category object) throws Exception {
        return update(object,object.getId());
    }

    public Boolean update(Category object, UUID id) throws Exception {
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

    public Boolean delete(UUID id) {
 
        if (findById(id).isEmpty()){
            return false;
        }
        
        repositoryCategory.deleteById(id);

        return true;
    }

    public Optional<Category> findById(UUID id)  {
        return repositoryCategory.findById(id);
    }

    public List<Category> findAll() {
        return repositoryCategory.findAll();
    }
    
}
