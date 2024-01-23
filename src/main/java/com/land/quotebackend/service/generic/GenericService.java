package com.land.quotebackend.service.generic;

import com.land.quotebackend.entity.BaseEntity;

import java.util.List;

public interface GenericService<T extends BaseEntity> {

    List<T> getAll(int index, int count);
    T getById(String id);

    void save(T entity);
    void update(T entity);
    void deleteById(String id);
}
