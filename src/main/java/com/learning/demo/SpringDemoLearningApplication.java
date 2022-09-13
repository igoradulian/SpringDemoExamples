package com.learning.demo;

import com.learning.demo.entity.Role;
import com.learning.demo.repository.RoleRepository;
import com.learning.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoLearningApplication implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoLearningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
    }

    private void initRoles()
    {
        roleService.saveRole(new Role("ADMIN"));
        roleService.saveRole(new Role("USER"));
        roleService.saveRole(new Role("GUEST"));
    }

}
