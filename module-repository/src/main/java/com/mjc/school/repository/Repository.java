package com.mjc.school.repository;

import java.util.List;

public interface Repository<T> {

    public T create(T t);

    public List<T> getAll();

    public T getById(Long id);

    public T update(T t);

    public Boolean delete(Long id);
}
