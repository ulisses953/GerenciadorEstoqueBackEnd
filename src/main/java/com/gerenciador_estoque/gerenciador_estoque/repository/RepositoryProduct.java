package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, Integer> {

    /**
     * function that aims to locate a product by id
     * 
     * @param id product id to find
     * @return the product
     * @author ulisses953
     */
    @Query(value = "SELECT * FROM Product where id = :id", nativeQuery = true)
    public Product getById(@Param("id") Integer id);
    
    
}
