package com.gerenciador_estoque.gerenciador_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;


@Repository
public interface RepositoryCategory extends JpaRepository<Category,Long>{

}
