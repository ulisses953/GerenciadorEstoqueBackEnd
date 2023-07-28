package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.ArrayList;
import java.util.Objects;

public interface service<T> {
    
    public boolean save(T object);

    public ArrayList<T> findAll();

    public Objects findById(long id);

    public boolean addProducts(ArrayList<T> objects);

    public boolean update(long id, T object);

    public boolean delete(long id);

}
