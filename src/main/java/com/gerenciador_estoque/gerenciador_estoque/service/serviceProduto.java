package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.ArrayList;


import com.gerenciador_estoque.gerenciador_estoque.model.Produto;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduto;

public class serviceProduto {

    private RepositoryProduto repositoryProduto = new RepositoryProduto();

    /**
     * adiciona produto a lista
     * 
     * @param produto produto a ser adicionado
     * @author ulisses
     */
    public boolean adicionar(Produto produto) {
        try {
            return repositoryProduto.adicionar(produto);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Localiza o produto com base do id
     * 
     * @param id id do produto
     * @return
     * @author ulisses
     */

    public Produto LocalizarId(int id) {
        return repositoryProduto.localizarId(id);
    }

    /**
     * deleta o produto no estoque
     * 
     * @param id id do produto
     * @return
     * @author ulisses
     */

    public boolean Deletar(int id) {
        return repositoryProduto.Deletar(id);
    }

    /**
     * Da um update em um produto
     * 
     * @param id      id do produto a ser trocado
     * @param produto produto a ser trocado
     * @return retorna um boolean
     * @author ulisses
     */
    public boolean Update(Produto produto, Integer id) {
        return repositoryProduto.Update(produto, id);
    }
    /**
     * Obter todos os produtos
     * @return
     */

    public ArrayList<Produto> ObterTodos(){
        try {
            return repositoryProduto.ObterTodos();
        } catch (Exception e) {
            return null;
        }
    } 

}
