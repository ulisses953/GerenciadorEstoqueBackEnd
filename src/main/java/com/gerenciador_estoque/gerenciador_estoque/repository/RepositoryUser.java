package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, UUID> {

    
}
