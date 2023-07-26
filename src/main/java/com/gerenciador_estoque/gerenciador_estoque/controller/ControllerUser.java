package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.User;
import com.gerenciador_estoque.gerenciador_estoque.service.SeviceUser;

@RestController
@RequestMapping("api/user")
public class ControllerUser {
    @Autowired
    private SeviceUser serviceUser;

    @GetMapping
    public List<User> findAll(){
        return serviceUser.findAll();
    }

    @GetMapping("/{id}")
    public User findbyid(@PathVariable long id){
        return serviceUser.findByid(id);
    }

    
}
