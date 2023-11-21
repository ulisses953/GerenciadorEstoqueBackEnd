package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Category save(@Valid Category object) throws Exception {
        return repositoryCategory.save(object);
    }

    @Override
    public Category update(Category object) throws Exception {
        return update(object,object.getId());
    }

    @Override
    public Category update(Category object, Long id) throws Exception {
        if (findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with ID" +id+" not found");
        }

        object.setId(id);

        return repositoryCategory.save(object);
       
    }

    @Override
    public Category delete(Long id) throws Exception {
        final Category category = findById(id).get();

        repositoryCategory.delete(category);

        return category;
    }

    @Override
    public Optional<Category> findById(Long id) throws Exception {
        if (id == null) {
            return null;
        }

        return repositoryCategory.findById(id);
    }

    @Override
    public List<Category> findAll() throws Exception {
        return repositoryCategory.findAll();
    }
    
}
