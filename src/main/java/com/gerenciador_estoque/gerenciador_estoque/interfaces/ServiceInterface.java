package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

public interface ServiceInterface<T, ID> {
    
    public T save(@Valid T object) throws Exception;
    
    public T update(T object) throws Exception;

    public T update(T object,ID id)throws Exception;

    public T delete(ID id)throws Exception;
    
    public Optional<T> findById(ID id)throws Exception;

    public List<T> findAll()throws Exception;
}
