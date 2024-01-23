package com.land.quotebackend.repository.generic;

import com.land.quotebackend.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity, Y> extends JpaRepository<T,Y> {
}
