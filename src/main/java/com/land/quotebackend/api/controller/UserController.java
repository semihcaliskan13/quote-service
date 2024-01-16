package com.land.quotebackend.api.controller;

import com.land.quotebackend.entity.User;
import com.land.quotebackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User saveUser(@RequestBody UserRequest user) {
        return userService.saveUser(new User(null,user.username(),user.email(),user.password(),null,null));
    }
}

record UserRequest(
        String username,
        String email,
        String password
){

}
