package com.gerenciador_estoque.gerenciador_estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;

public interface RepositoryCategory extends JpaRepository<Category, Long>{
    
    //@Query(value = "",nativeQuery = true)
}
