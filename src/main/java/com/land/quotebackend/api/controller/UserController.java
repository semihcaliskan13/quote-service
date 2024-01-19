package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.user.UserCreateRequest;
import com.land.quotebackend.dto.request.user.UserUpdateRequest;
import com.land.quotebackend.dto.response.user.UserGetAllResponse;
import com.land.quotebackend.dto.response.user.UserGetByIdResponse;
import com.land.quotebackend.entity.User;
import com.land.quotebackend.mapper.UserMapper;
import com.land.quotebackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserGetAllResponse> getUser(@RequestParam int index, @RequestParam int count) {
        return UserMapper.INIT.userToGetAllResponse(userService.getAllUsers(index,count));
    }

    @GetMapping("{id}")
    public UserGetByIdResponse getUserById(@PathVariable String id){
        return UserMapper.INIT.userToGetByIdResponse(userService.getUserById(id));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid UserCreateRequest request) {
        userService.saveUser(UserMapper.INIT.userCreateRequestToUser(request));
    }

    @PutMapping
    public void updateUser(@RequestBody @Valid UserUpdateRequest request){
        userService.updateUser(UserMapper.INIT.userUpdateRequestToUser(request));
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
    }
}