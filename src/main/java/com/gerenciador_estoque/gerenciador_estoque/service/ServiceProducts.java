package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

import jakarta.persistence.EntityNotFoundException;

@Service
@Validated
public class ServiceProducts {
    @Autowired
    private RepositoryProduct repositoryProduct;
    @Autowired
    private RepositoryCategory repositoryCategory;

    public Boolean save(Product object) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null");
        }
        if (object.getId() != null) {
            if (repositoryProduct.findById(object.getId()).isPresent()) {
                throw new IllegalArgumentException("id entered already exists");
            }
        }
        if (object.getCategories() == null ) {
            repositoryProduct.save(object);
            return true;
        }

        if (object.getCategories().size() == 0 ) {
            repositoryProduct.save(object);
            return true;
        }

        object.setCategories(updateProductCategoriesFromDatabase(object));

        repositoryProduct.save(object);

        return true;

    }
    /**
     * Essa funcao tem como objetivo verifiar se o id informado esta no banco de dados e pegar o valor
     * @param object
     * @return
     */
    public List<Category> updateProductCategoriesFromDatabase(Product object) {
        
        List<Category> newCategories = new ArrayList<Category>();

        for (Category category : object.getCategories()) {
            if (category.getId() == null) {
                newCategories.add(category);
            } else {
                newCategories.add(repositoryCategory.findById(category.getId())
                        .orElseThrow(() -> new EntityNotFoundException("id não encontrado : " + category.getId())));
            }
        }

        return newCategories;

    }

    public Boolean update(Product object) throws Exception {
        return update(object, object.getId());
    }

    public Boolean update(Product object, UUID id) throws Exception {
        if (findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with ID" + id + " not found");
        }
        if (object == null) {
            throw new IllegalArgumentException("object is not null");
        }

        object.setId(id);

        repositoryProduct.save(object);

        return true;

    }

    public Product delete(UUID id) throws EntityNotFoundException,IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        
        Product product = repositoryProduct.findById(id).orElseThrow(()->
            new EntityNotFoundException("Produto não encontrado com o ID: " + id)
        );
        
        product.getCategories().clear();

        repositoryProduct.save(product);

        repositoryProduct.deleteById(product.getId());

        return product;
    }

    public Optional<Product> findById(UUID id) throws Exception {
        return repositoryProduct.findById(id);
    }

    public List<Product> findAll() throws Exception {
        return repositoryProduct.findAll();
    }

    public List<Product> getProductsByCategoryId(UUID id) {

        if (repositoryCategory.findById(id).isEmpty()) {
            throw new EntityNotFoundException("id not found");
        }

        return repositoryProduct.getProductsByCategoryId(id);
    }

}
