package com.gerenciador_estoque.gerenciador_estoque.model.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResorceNotFoundExeption extends RuntimeException {

    public ResorceNotFoundExeption(String mensage) {
        super(mensage);
    }
}
