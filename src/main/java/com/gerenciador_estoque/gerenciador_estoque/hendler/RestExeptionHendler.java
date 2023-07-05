package com.gerenciador_estoque.gerenciador_estoque.hendler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gerenciador_estoque.gerenciador_estoque.model.error.ErrorMensage;
import com.gerenciador_estoque.gerenciador_estoque.model.exeption.ResorceNotFoundExeption;

@ControllerAdvice
public class RestExeptionHendler {

    /**
     * 
     * @param ex
     * @return
     * @author ulisses
     */
    @ExceptionHandler(ResorceNotFoundExeption.class)
    public ResponseEntity<?> hendleResourceNotFondExeption(ResorceNotFoundExeption ex) {
        ErrorMensage errorMensage = new ErrorMensage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorMensage, HttpStatus.NOT_FOUND);
    }
}
