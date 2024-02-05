package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Stock;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/Stock")
public class ControllerStock {
    @Autowired
    private ServiceCategory serviceCategory;

    // @PostMapping()
    // public ResponseEntity<?> save(@RequestBody Stock object) {
    //     try {
    //         return new ResponseEntity<>(serviceCategory.save(object), HttpStatus.CREATED);
    //     } catch (IllegalArgumentException e) {
            
    //     } catch (Exception e) {

    //     }
        


       
    // }
    
}
