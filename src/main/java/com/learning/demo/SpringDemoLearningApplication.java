package com.learning.demo;

import com.learning.demo.entity.Role;
import com.learning.demo.entity.User;
import com.learning.demo.repository.UserRepository;
import com.learning.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author Igor Adulyan
 *
 * CommandlineRunner initlize
 * user roles and admin user
 * on application start up
 *
 * User can add just regular users
 *
 * 1) urls available
 * "localhost:8080/login"
 * "localhost:8080/sign-up"
 * "localhost:8080/home"
 */

@SpringBootApplication
public class SpringDemoLearningApplication implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoLearningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
    }

    private void initRoles()
    {
        roleService.saveRole(new Role("ROLE_ADMIN"));
        roleService.saveRole(new Role("ROLE_USER"));
        roleService.saveRole(new Role("ROLE_GUEST"));
    }

    private void initUsers()
    {
        //Login 'admin@admin.com'
        //Password 'test'
        userRepository.save(new User("admin", "Jack", "Smith", "admin@admin.com", "998-098-0987",
                "12345", "$2a$11$DZfZLO720bZby.1QWCu81.gg2BUYCJC7PSsjEUMho.ZaVUVC1h9ZC"));

        User user=  userRepository.findUserByEmail("admin@admin.com");
        user.setRoles(Arrays.asList(roleService.findRoleByRoleName("ROLE_ADMIN")));

        userRepository.save(user);


    }

}
