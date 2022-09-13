package com.learning.demo.service;

import com.learning.demo.dto.UserDTO;
import com.learning.demo.entity.User;
import com.learning.demo.repository.UserRepository;
import com.learning.demo.security.UserPrincipal;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository,RoleService roleService) {
        super();
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByEmail(userName);
        if(null == user)
        {
            throw new UsernameNotFoundException("Cannot find username " + userName);
        }
        return new UserPrincipal(user);
    }

    /**
     * Using model mapper
     * helps to avoid extra
     * coding
     * @param userDTO
     */
    public void creat(UserDTO userDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userDTO, User.class);

        user.setRoles(Arrays.asList(roleService.findRoleByRoleName("USER")));

        userRepository.save(user);
    }
}

