package com.gerenciador_estoque.gerenciador_estoque.interfaces;

import java.util.List;

public interface ControllerInterfece<T> {

    public boolean save(T object);

    public List<T> findAll();

    public T findById(long id);

    public boolean saveAll(List<T> objects);

    public boolean update(long id, T object);

    public boolean delete(long id);

}
