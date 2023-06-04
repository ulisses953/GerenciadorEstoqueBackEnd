package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.ArrayList;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private double valorVenda;
    private double valorCompra;
    public ArrayList<Categoria> categoria;
    private Fornecedor fornecedor;

    // #region get e set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    // #endregion

    
    // #region constructores

    public Produto(Integer id, String nome, String descricao, double valorVenda, double valorCompra,
            ArrayList<Categoria> categoria, Fornecedor fornecedor) {        
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public Produto() {

    }

    // #endregion

}
