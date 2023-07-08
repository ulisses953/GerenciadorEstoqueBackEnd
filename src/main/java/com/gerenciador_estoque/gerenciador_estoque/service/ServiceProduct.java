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

    /**
     * Function add product to database
     * 
     * @param Product product to be added to the database
     * @return
     * @author ulisses953
     */
    public boolean save(Product Product){
        repositoryProduct.save(Product);
        return true;
    }

    /**
     * Take all products from the bank
     * 
     * @return
     * @author ulisses953
     */
    public ArrayList<Product> findAll(){
        return (ArrayList<Product>) repositoryProduct.findAll();
    }
    /**
     * find a product by id in the bank
     *  
     * @param id id to be located in the bank
     * @return product that was found
     * @author ulisses953
     */
    public Product getById(Integer id){
        return repositoryProduct.getById(id);
    }
    /**
     * 
     * @param products
     * @return
     * @author ulisses953
     */
    public boolean addProducts(ArrayList<Product> products){
        repositoryProduct.saveAll(products);
        return true;
    }
    /**
     * 
     * @param id
     * @param product
     * @return
     * @author ulisses953
     */
    public boolean update(int id, Product product){
        product.setId(id);
        repositoryProduct.save(product);
        return true;
    }
    /**
     * 
     * @param id
     * @return
     * @author ulisses953
     */
    public boolean delete(int id){
        repositoryProduct.deleteById(id);
        return true;
    }
}
