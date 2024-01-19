package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    List<Role> findAllByUsers(List<User> users);
}
