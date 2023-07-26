package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gerenciador_estoque.gerenciador_estoque.enuns.Powers;
import com.gerenciador_estoque.gerenciador_estoque.model.User;

public interface RepositoruUser extends JpaRepository<User, Long> {

    @Query(value = "Select * from tb_user where powers = :powers", nativeQuery = true)
    public ArrayList<User> locateByPower(@Param("powers") Powers powers);

    @Query(value = "Select * from tb_user where email = :email and password = :password", nativeQuery = true)
    public User loginbyEmail(@Param("email")String email, @Param("password") String password);

    
}
