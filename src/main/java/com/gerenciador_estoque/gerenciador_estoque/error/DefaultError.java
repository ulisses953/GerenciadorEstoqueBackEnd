package com.gerenciador_estoque.gerenciador_estoque.error;

import java.util.Date;

public class DefaultError {
    private String title;
    private String mensage;
    private Date date;
    private int code;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMensage() {
        return mensage;
    }
    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public DefaultError(String title, String mensage, Date date, int code) {
        this.title = title;
        this.mensage = mensage;
        this.date = date;
        this.code = code;
    }
    

    
}
