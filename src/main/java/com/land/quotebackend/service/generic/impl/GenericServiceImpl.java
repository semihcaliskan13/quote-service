package com.land.quotebackend.service.generic.impl;

import com.land.quotebackend.entity.BaseEntity;
import com.land.quotebackend.repository.generic.GenericRepository;
import com.land.quotebackend.service.generic.GenericService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

    private final GenericRepository<T, String> repository;

    public GenericServiceImpl(GenericRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<T> getAll(int index, int count) {
        Pageable page = PageRequest.of(index,count, Sort.by("createdAt").descending());
        return repository.findAll(page).getContent();
    }

    @Override
    public T getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    public void update(T entity) {
        if (repository.existsById(entity.getId())){
            repository.save(entity);
        }

    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
