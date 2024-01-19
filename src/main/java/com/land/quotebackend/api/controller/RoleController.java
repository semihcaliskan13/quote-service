package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.role.RoleCreateRequest;
import com.land.quotebackend.dto.request.role.RoleUpdateRequest;
import com.land.quotebackend.dto.response.role.RoleGetAllResponse;
import com.land.quotebackend.dto.response.role.RoleGetByIdResponse;
import com.land.quotebackend.mapper.RoleMapper;
import com.land.quotebackend.service.RoleService;
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

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService _roleService;

    public RoleController(RoleService roleService) {
        _roleService = roleService;
    }

    @GetMapping
    public List<RoleGetAllResponse> getAllRoles(@RequestParam int index, @RequestParam int count) {
        return RoleMapper.INIT.roleToGetAllResponse(_roleService.getAllRoles(index, count));
    }

    @GetMapping(value = "{id}")
    public RoleGetByIdResponse getRoleById(@PathVariable String id) {
        return RoleMapper.INIT.roleToGetByIdResponse(_roleService.getRoleById(id));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRole(@RequestBody RoleCreateRequest request) {
        _roleService.createRole(RoleMapper.INIT.roleCreateRequestToRole(request));
    }

    @PutMapping
    public void updateRole(@RequestBody RoleUpdateRequest request) {
        _roleService.updateRole(RoleMapper.INIT.roleUpdateRequestToRole(request));
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRoleById(@PathVariable String id){
        _roleService.deleteRole(id);
    }
}
