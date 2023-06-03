package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.ArrayList;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private double valorVenda;
    private ArrayList<Categotia> categoria;

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

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valorVenda=" + valorVenda
                + ", categoria=" + categoria + "]";
    }

}
