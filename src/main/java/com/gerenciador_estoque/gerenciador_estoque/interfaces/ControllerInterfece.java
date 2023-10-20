package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterfece<T> {

    public List<T> findAll();

    public T findById(Integer id);

    public ResponseEntity<?> save(T object);

    public ResponseEntity<?> addProducts(ArrayList<T> objects);

    public  ResponseEntity<?>  delete(int id);

    public  ResponseEntity<?>  update(int id, T object); 
}
