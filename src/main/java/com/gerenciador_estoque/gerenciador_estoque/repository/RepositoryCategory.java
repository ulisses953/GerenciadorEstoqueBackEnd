package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.CategoryAmountProjection;
import com.gerenciador_estoque.gerenciador_estoque.model.Category;

@Repository
public interface RepositoryCategory extends JpaRepository<Category, UUID> {

    @Query(value = "select tc.name, count(tp.id) as amount from tb_category tc inner join tb_category_product tcp ON tcp.category_id = tc.id inner join tb_product tp on tp.id = tcp.product_id GROUP BY tc.name", nativeQuery = true)
    public List<CategoryAmountProjection> categoryAmount();

    
}