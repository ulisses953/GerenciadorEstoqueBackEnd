package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.service.SeviceUser;

@RestController
@RequestMapping("api/user")
public class ControllerUser {
    @Autowired
    private SeviceUser seviceUser;

    
}
