package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;
import com.land.quotebackend.excepiton.UserNotFoundException;
import com.land.quotebackend.repository.UserRepository;
import com.land.quotebackend.service.RoleService;
import com.land.quotebackend.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public List<User> getAllUsers(int index, int count) {
        Pageable pageable = PageRequest.of(index, count);
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public List<User> getAllUsersByRole(List<Role> role) {
        return userRepository.findUsersByRolesIn(role);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        user.getRoles().size();
        return user;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void addRolesToUser(String id, List<String> roleIds) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        var roles = roleService.getRolesByIds(roleIds);
        if (roles!=null){
            user.getRoles().addAll(roles);
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
        throw new UserNotFoundException("Cannot update user because user not exist with id: " + user.getId());
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
