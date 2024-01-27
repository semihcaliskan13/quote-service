package com.land.quotebackend.service;


import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles(int index, int count);
    List<Role> getUserRoles(List<User> users, int index, int count);

    List<Role> getRolesByIds(List<String> ids);
    Role getRoleById(String id);
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(String id);
}
