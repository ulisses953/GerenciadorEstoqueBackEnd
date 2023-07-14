package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, Long> {
    
}
