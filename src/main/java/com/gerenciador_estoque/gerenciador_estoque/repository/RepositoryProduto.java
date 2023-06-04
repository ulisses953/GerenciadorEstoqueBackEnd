package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.gerenciador_estoque.gerenciador_estoque.model.Produto;

@Repository
public class RepositoryProduto {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private int id = 0;

    public void addProduto(Produto produto){
        produto.setId(id++);
        produtos.add(produto);
    }

    public Produto localizarId(int id){
       for (Produto produto : produtos) {
        if(produto.getId() == id){
            return produto;
        }
       }
       return null;
    }

    public void DeletarProduto(int id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public void update(Integer id, Produto produto){
        DeletarProduto(id);
        produto.setId(id);
        addProduto(produto);
    }
}
