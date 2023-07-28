package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gerenciador_estoque.gerenciador_estoque.model.User;
import com.gerenciador_estoque.gerenciador_estoque.service.SeviceUser;


@RestController
@RequestMapping("api/user")
public class ControllerUser {
    @Autowired
    private SeviceUser serviceUser;

    @GetMapping
    public ArrayList<User> findAll(){
        return serviceUser.findAll();
    }

    @GetMapping("/{id}")
    public User findbyid(@PathVariable long id){
        return serviceUser.findByid(id);
    }

    @GetMapping("/login")
    public User loginbyEmail(@RequestBody String email, @RequestBody String password){
        return serviceUser.loginbyEmail(email, password);
    }

    @PostMapping()
    public boolean save(@RequestBody User user){
        return serviceUser.save(user);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id ,@RequestBody User user){
        return serviceUser.update(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){
        return serviceUser.delete(id);
    }
    
}
