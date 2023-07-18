package com.gerenciador_estoque.gerenciador_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoruUser;

@Service
public class SeviceUser {
    @Autowired
    private RepositoruUser repositoruUser;
    
    
}
