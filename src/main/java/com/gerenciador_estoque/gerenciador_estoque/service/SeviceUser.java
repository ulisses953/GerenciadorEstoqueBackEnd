package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.User;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryUser;

@Service
public class SeviceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    

}
