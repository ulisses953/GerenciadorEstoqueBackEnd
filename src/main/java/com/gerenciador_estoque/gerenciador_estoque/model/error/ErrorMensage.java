package com.gerenciador_estoque.gerenciador_estoque.model.error;

public class ErrorMensage {

    private String titulo;

    private int status;

    private String mensagem;

    //#region constuctor
    public ErrorMensage(String titulo, int status, String mensage) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensage;
    }
    //#endregion

    //#region get and set
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensage) {
        this.mensagem = mensage;
    }
    //#endregion
    
}
