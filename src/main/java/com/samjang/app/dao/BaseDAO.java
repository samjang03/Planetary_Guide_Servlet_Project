package com.samjang.app.dao;

import com.samjang.app.model.Entity;

import java.util.List;

public interface BaseDAO<T extends Entity, V extends Object> {
    List<T> getAll();

    T getById(V id);

    void add(T entity);

    void update(T entity);

    void delete(V id);
}
