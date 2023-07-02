package com.gerenciador_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;

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

    public Produto localizarId(int id) {
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
    public boolean update(Produto produto, Integer id) {
        return repositoryProduto.update(produto, id);
    }

    // #region construcor
    public serviceProduto(RepositoryProduto repositoryProduto) {
        this.repositoryProduto = repositoryProduto;
    }

    public serviceProduto() {
    }
    // #endregion

}
