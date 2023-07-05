package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceProduto;

@RestController
@RequestMapping("/api/produtos")
public class ControllerProduto {
    @Autowired
    private ServiceProduto serviceProduto;

    /**
     * 
     * @return
     */
    @GetMapping
    public ArrayList<Produto> ObterTodos() {
        return serviceProduto.obterTodos();
    }

    /**
     * 
     * @param produto
     * @return
     */

    @PostMapping
    public boolean adicionar(@RequestBody Produto produto) {
        return serviceProduto.adicionar(produto);
    }

    /**
     * 
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public Produto localizarId(@PathVariable int id) {
        return serviceProduto.localizarId(id);
    }

    /**
     * 
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable int id) {
        return serviceProduto.deletar(id);
    }

    /**
     * 
     * @param produto
     * @param id
     * @return
     */

    @PutMapping("{id}")
    public boolean update(@RequestBody Produto produto, @PathVariable int id) {
        return serviceProduto.update(produto, id);
    }

    public ControllerProduto(ServiceProduto serviceProduto) {
        this.serviceProduto = serviceProduto;
    }

    
    
}
