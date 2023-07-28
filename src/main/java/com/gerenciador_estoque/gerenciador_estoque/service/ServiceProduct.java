package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

@Service
public class ServiceProduct {
    @Autowired
    private RepositoryProduct repositoryProduct;

    public boolean save(Product Product) {
        repositoryProduct.save(Product);
        return true;
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
