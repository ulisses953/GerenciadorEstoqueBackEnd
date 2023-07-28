package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.User;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoruUser;

@Service
public class SeviceUser {
    @Autowired
    private RepositoruUser repositoruUser;

    public User loginbyEmail(String email, String password) {
        return repositoruUser.loginbyEmail(email, password);
    }

    public User findByid(Long id) {
        return (User) repositoruUser.findById(id).get();
    }

    public boolean save(User user) {
        repositoruUser.save(user);
        return true;
    }

    public boolean delete(Long id) {
        repositoruUser.deleteById(id);
        return true;
    }

    public boolean update(Long id, User user) {
        user.setId(id);
        repositoruUser.save(user);
        return true;
    }

    public ArrayList<User> findAll() {
        return (ArrayList<User>) repositoruUser.findAll();
    }

}
