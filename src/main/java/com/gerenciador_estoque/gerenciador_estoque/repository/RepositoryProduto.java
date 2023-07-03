package com.gerenciador_estoque.gerenciador_estoque.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;

@Repository
public class RepositoryProduto {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private int id = 0;

    /**
     * adiciona produto a lista
     * @param produto produto a ser adicionado
     * @author ulisses
     */
    public boolean adicionar(Produto produto) {
        try {
            return adicionar(produto, id++);
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }
    /**
     * adicona um produto a lista mudando com o id informado
     * @param produto
     * @param id
     * @return retorna um boolean 
     * @author ulisses
     */
    public boolean adicionar(Produto produto, int id){
        try {
            produto.setId(id);
            return produtos.add(produto);
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    /**
     * Localiza o produto com base do id
     * @param id id do produto
     * @return
     * @author ulisses
     */
    public Produto localizarId(int id) {
        try {
            for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }

    /**
     * deleta o produto no estoque
     * @param id id do produto
     * @return
     * @author ulisses
     */
    public boolean Deletar(int id) {
        try {
            return produtos.removeIf(produto -> produto.getId() == id);
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }

    }
    /**
     * Da um update em um produto
     * @param id id do produto a ser trocado
     * @param produto produto a ser trocado
     * @return retorna um boolean
     * @author ulisses
     */
    public boolean Update( Produto produto,Integer id) {
        try {
           
            if (null == localizarId(id)) {
                throw new Exception("Nao existe um produto com o id informado");
            }

            if (false == Deletar(id)) {
                throw new Exception("Erro ao deletar o produto");
            }
            
            if(false == adicionar(produto)){
                throw new Exception("Erro em adicionar produto");
            }  
            produto.setId(id);
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }
    /**
     * funcao para pegar todos os produtos 
     * @return lista de produto
     * @author ulisses
     */

    public ArrayList<Produto> ObterTodos(){
        try {
            return produtos;
        } catch (Exception e) {
            return null;
        }
    }
}
