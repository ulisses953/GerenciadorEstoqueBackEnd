package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

@Service
public class ServiceProduct {
    @Autowired
    private RepositoryProduct repositoryProduct;
    @Autowired
    private RepositoryCategory repositoryCategory;
    
    public boolean save(Product product) {
        
        product.setCategory(filterCategories(product.getCategory()));
        
        repositoryProduct.save(product);

        return true;
    }
    /**
     * This function aims to find the product id in the database
     * @param categories
     * @return
     */
    protected List<Category> filterCategories(List<Category> categories) {
        List<Category> filteredCategory = new ArrayList<Category>();
        for (Category category : categories) {
            category = repositoryCategory.findById(category.getId()).get();
            if( category != null ) {
                filteredCategory.add(category);
            }else {
                
            }
        }
        return filteredCategory;
    }

    public List<Product> findAll() {
        return (List<Product>) repositoryProduct.findAll();
    }

    public Product findById(long id) {
        return (Product) repositoryProduct.findById(id).get();
    }

    public boolean addProducts(List<Product> products) {
        repositoryProduct.saveAll(products);
        return true;
    }

    public boolean update(long id, Product product) {
        product.setId(id);
        repositoryProduct.save(product);
        return true;
    }

    public boolean delete(long id) {
        repositoryProduct.deleteById(id);
        return true;
    }

}
