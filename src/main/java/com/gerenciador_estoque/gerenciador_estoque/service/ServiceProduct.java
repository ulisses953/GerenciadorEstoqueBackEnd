package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

@Service
public class ServiceProduct {
    @Autowired
    private RepositoryProduct repositoryProduct;

    public boolean addProduct(Product Product){
        repositoryProduct.save(Product);
        return true;
    }

    public ArrayList<Product> getAll(){
        return repositoryProduct.getAll();
    }

    public boolean addProducts(ArrayList<Product> products){
        repositoryProduct.saveAll(products);
        return true;
    }
    
    public boolean update(int id, Product product){
        product.setId(id);
        repositoryProduct.save(product);
        return true;
    }

    public boolean delete(int id){
        repositoryProduct.deleteById(id);
        return true;
    }
}
