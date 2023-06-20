package com.mjc.school.service;

import java.util.List;

public interface Service<T> {
    public T create(T t);

    public List<T> readAll();

    public T readById(Long id);

    public T update(T t);

    public Boolean delete(Long id);
}
