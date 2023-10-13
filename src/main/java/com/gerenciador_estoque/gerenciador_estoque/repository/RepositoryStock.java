package com.gerenciador_estoque.gerenciador_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador_estoque.gerenciador_estoque.model.Stock;

public interface RepositoryStock extends JpaRepository<Stock, Long>{

}
