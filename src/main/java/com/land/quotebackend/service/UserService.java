package com.land.quotebackend.service;

import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers(int index, int count);
    List<User> getAllUsersByRole(List<Role> role);
    User getUserById(String id);
    User getUserByUsername(String username);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(String id);
}
