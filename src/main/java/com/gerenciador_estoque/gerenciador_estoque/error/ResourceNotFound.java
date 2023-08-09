package com.gerenciador_estoque.gerenciador_estoque.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    
    
}