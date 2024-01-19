package com.land.quotebackend.service;


import com.land.quotebackend.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles(int index, int count);
    Role getRoleById(String id);
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(String id);
}
