package com.gerenciador_estoque.gerenciador_estoque.model;

public class Categotia {
    private int id;
    private String nome;
    private String categoria;

    public Categotia(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categotia [id=" + id + ", nome=" + nome + ", categoria=" + categoria + "]";
    }
}
