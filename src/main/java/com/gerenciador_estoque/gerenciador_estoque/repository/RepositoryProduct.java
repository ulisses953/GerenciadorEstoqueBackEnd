package com.gerenciador_estoque.gerenciador_estoque.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, UUID> {

    @Query(value = "select tp.* from tb_product tp inner join tb_category_product tcp on tcp.product_id = tp.id where tcp.category_id = :id",nativeQuery = true)
    public List<Product> getProductsByCategoryId(UUID id);

    


} 