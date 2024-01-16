package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.User;
import com.land.quotebackend.excepiton.UserNotFoundException;
import com.land.quotebackend.repository.UserRepository;
import com.land.quotebackend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: "+id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username: "+username));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }
        throw new UserNotFoundException("Cannot update user because user not exist with id: " + user.getId());
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
