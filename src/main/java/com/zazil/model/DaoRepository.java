package com.zazil.model;

import java.util.List;

public interface DaoRepository<T>{

    List<T> findAll();
    T findOne(int id);

    boolean update(int id, T object);

    boolean delete(int id);
}
