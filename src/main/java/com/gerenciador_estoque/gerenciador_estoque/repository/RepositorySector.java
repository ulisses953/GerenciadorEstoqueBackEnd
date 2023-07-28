package com.gerenciador_estoque.gerenciador_estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciador_estoque.gerenciador_estoque.model.Sector;

public interface RepositorySector extends JpaRepository<Sector, Long>{
    
    //@Query(value = "",nativeQuery = true)
}
