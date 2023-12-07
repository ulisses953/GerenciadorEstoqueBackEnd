package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ServiceInterface;
import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
@Validated
public class ServiceProducts implements ServiceInterface<Product, Long> {
    @Autowired
    private RepositoryProduct repositoryProduct;
    @Autowired
    private RepositoryCategory repositoryCategory;

    @Override
    public Boolean save(@Valid Product object) throws Exception {
        if (object == null) {
            throw new IllegalArgumentException("object is not null");
        }

        object.setCategories(updateProductCategoriesFromDatabase(object));

        if (object == repositoryProduct.save(object)) {
            return true;
        }
        
        return false;

    }

    private List<Category> updateProductCategoriesFromDatabase(Product object) {

        List<Category> newCategories = new ArrayList<Category>();

        for (Category category : object.getCategories()) {
            Optional<Category> CategoryDatabese = repositoryCategory.findById(category.getId());
            if (CategoryDatabese.isPresent()) {
               category = CategoryDatabese.get();
            }

            newCategories.add(category);
        }

        return newCategories;

    }

    @Override
    public Boolean update(@Valid Product object) throws Exception {
        return update(object, object.getId());
    }

    @Override
    public Boolean update(@Valid Product object, Long id) throws Exception  {
        if (findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with ID" + id +" not found");
        }
        if (object == null){
            throw new IllegalArgumentException("object is not null");
        }

        object.setId(id);

        repositoryProduct.save(object);

        return true;

    }

    @Override
    public Boolean delete(Long id) throws Exception {
        if (findById(id).isEmpty()) {
            return false;
        }

        repositoryProduct.deleteById(id);

        return true;
    }

    @Override
    public Optional<Product> findById(Long id) throws Exception {
        if(id < 0){
            return Optional.empty();
        }

        return repositoryProduct.findById(id);
    }

    @Override
    public List<Product> findAll() throws Exception {
        return repositoryProduct.findAll();
    }
    
    public List<Product> getProductsByCategoryId(Long id){
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
        if (repositoryCategory.findById(id).isEmpty()){
            throw new EntityNotFoundException("id not found");
        }

        return repositoryProduct.getProductsByCategoryId(id);
    }
    

}
