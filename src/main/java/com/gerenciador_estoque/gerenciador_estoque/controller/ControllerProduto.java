package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;
import com.gerenciador_estoque.gerenciador_estoque.service.serviceProduto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ControllerProduto {
    
    private serviceProduto serviceProduto = new serviceProduto();

    @GetMapping
    public ArrayList<Produto> ObterTodos(){
        try {
            return serviceProduto.ObterTodos();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    public boolean Adicionar(@RequestBody Produto produto){
        try {
            return serviceProduto.adicionar(produto);
        } catch (Exception e) {
            return false;
        }
    }
    @GetMapping("/{id}")
    public Produto LocalizarId(@PathVariable int id){
        try {
            return serviceProduto.LocalizarId(id);
        } catch (Exception e) {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public boolean DeletarDe(@PathVariable int id){
        try {
            return serviceProduto.Deletar(id);
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/update/{id}")
    public boolean Update(@RequestBody Produto produto, @PathVariable int id){
        try {
            System.out.println(produto.toString() + id);
            return serviceProduto.Update(produto, id);
        } catch (Exception e) {
            return false;
        }
    }

    
}
