package com.learning.demo.service;

import com.learning.demo.entity.Role;

public interface RoleService {

    public void saveRole(Role role);
    public Role findRoleByRoleName(String name);
}
