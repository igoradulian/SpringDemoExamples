package com.learning.demo.service;

import com.learning.demo.entity.Role;

import java.util.List;

public interface RoleService {

    public void saveRole(Role role);
    public Role findRoleByRoleName(String name);
    public List<Role> getAllRoles();
    public List<Role> getRolesByUser(long id);
}
