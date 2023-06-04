package com.gerenciador_estoque.gerenciador_estoque.model;

public class Fornecedor {
    private int idfornecedor;
    private String nome;
    private String email;

    // #region
    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // #endregion
}
