package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.ArrayList;

public interface ControllerInterfece<T> {

    public boolean save(T object);

    public ArrayList<T> findAll();

    public T findById(long id);

    public boolean saveAll( ArrayList<T> objects);

    public boolean update(long id, T object);

    public boolean delete(long id);

}
