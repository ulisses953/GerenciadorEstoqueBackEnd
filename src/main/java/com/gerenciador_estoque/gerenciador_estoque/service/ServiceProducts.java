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
    public Boolean update(Product object) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean update(@Valid Product object, Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Product> findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Product> findAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
