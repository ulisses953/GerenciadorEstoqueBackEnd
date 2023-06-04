package com.gerenciador_estoque.gerenciador_estoque.model;

public class Categoria {
    private int idCategoria;
    private String nome;
    private String descrisao;

    // #region get e set
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }
    // #endregion

}
