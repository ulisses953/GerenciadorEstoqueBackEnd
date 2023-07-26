package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.ArrayList;
import java.util.Objects;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;

public interface service {
    public boolean save(Object object);

    public ArrayList<Objects> findAll();

    public Objects findById(long id);

    public boolean addProducts(ArrayList<Object> objects);

    public boolean update(long id, Object object);

    public boolean delete(long id);

}
