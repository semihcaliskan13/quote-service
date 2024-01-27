package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;
import com.land.quotebackend.excepiton.RoleNotFoundException;
import com.land.quotebackend.repository.RoleRepository;
import com.land.quotebackend.service.RoleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository _roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        _roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles(int index, int count) {
        return _roleRepository.findAll(PageRequest.of(index, count)).getContent();
    }

    @Override
    public List<Role> getUserRoles(List<User> users, int index, int count) {
        return _roleRepository.findAllByUsersIn(users, PageRequest.of(index,count)).getContent();
    }

    @Override
    public List<Role> getRolesByIds(List<String> ids) {
        return _roleRepository.findAllById(ids);
    }

    @Override
    public Role getRoleById(String id) {
        return _roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(String.format("Role with id: %s is not found!", id)));
    }

    @Override
    public void createRole(Role role) {
        _roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        if (_roleRepository.existsById(role.getId())){
            _roleRepository.save(role);
            return;
        }
        throw new RoleNotFoundException(String.format("Role with id: %s is not found! CANNOT UPDATE!",role.getId()));
    }

    @Override
    public void deleteRole(String id) {
        _roleRepository.deleteById(id);
    }
}
