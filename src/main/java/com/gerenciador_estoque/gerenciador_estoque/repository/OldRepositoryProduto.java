package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;
import com.gerenciador_estoque.gerenciador_estoque.model.exeption.ResorceNotFoundExeption;

@Repository
public class OldRepositoryProduto {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private int id = 0;

    /**
     * adiciona produto a lista
     * 
     * @param produto produto a ser adicionado
     * @author ulisses
     */
    public boolean adicionar(Produto produto) {

        return adicionar(produto, id++);

    }

    /**
     * adicona um produto a lista mudando com o id informado
     * 
     * @param produto
     * @param id
     * @return retorna um boolean
     * @author ulisses
     */
    public boolean adicionar(Produto produto, int id) {
        produto.setId(id);
        return produtos.add(produto);
    }

    /**
     * Localiza o produto com base do id, se caso nao encontrar o produto gera um
     * erro 404
     * 
     * @param id id do produto
     * @return
     * @author ulisses
     */
    public Produto localizarId(int id) {
        if (id < 0) {
            throw new ResorceNotFoundExeption("Id negativo");
        }
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new ResorceNotFoundExeption("Id do produto nao encontrado");

    }

    /**
     * deleta o produto no estoque
     * 
     * @param id id do produto
     * @return
     * @author ulisses
     */
    public boolean deletar(int id) {

        if (true == produtos.removeIf(produto -> produto.getId() == id)) {
            return true;
        } else {
            throw new ResorceNotFoundExeption("Id do produto nao encontrado");
        }

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
        return false;
    }

    /**
     * funcao para pegar todos os produtos
     * 
     * @return lista de produto
     * @author ulisses
     */

    public ArrayList<Produto> obterTodos() {
        return produtos;
    }
}
