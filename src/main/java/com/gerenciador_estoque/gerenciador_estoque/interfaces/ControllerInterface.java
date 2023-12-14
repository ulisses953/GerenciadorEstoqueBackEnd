package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import org.springframework.http.ResponseEntity;


public interface ControllerInterface<ID, T> {
    
    public ResponseEntity<?> save(T object);
    
    public  ResponseEntity<?> update( T object,ID id);

    public  ResponseEntity<?> delete(ID id);
    
    public  ResponseEntity<?> findById(ID id);

    public  ResponseEntity<?> findAll();
    
}
