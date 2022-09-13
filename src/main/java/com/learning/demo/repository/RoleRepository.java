package com.learning.demo.repository;

import com.learning.demo.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    public Role findRoleByName(String role);
}
