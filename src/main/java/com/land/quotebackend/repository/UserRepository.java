package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);
    List<User> findUsersByRolesIn(List<Role> roles);
}
