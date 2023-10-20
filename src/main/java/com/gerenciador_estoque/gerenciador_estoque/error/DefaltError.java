package com.gerenciador_estoque.gerenciador_estoque.error;

import java.util.Date;

public class DefaltError {
    
    private String title;
    private String message;
    private int code;
    private Date date;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public DefaltError() {
    }
    public DefaltError(String title, String message, int code, Date date) {
        this.title = title;
        this.message = message;
        this.code = code;
        this.date = date;
    }
    
    

    
}
