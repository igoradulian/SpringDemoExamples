package com.learning.demo.controller;

import com.learning.demo.dto.LoginDTO;
import com.learning.demo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Igor Adulyan
 */
@Controller
public class UserController {

    /**
     * In order to
     * make code more readable
     * it is good practice to
     * use special DTOs for login
     * It also make controllers
     * less dependent from entities
     * and separate validation from
     * jpa functionality
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model)
    {
        model.addAttribute("userDto", new UserDTO());

        return "sign-up";
    }

    @PostMapping("/signup-process")
    public String signupProcess(@Valid @ModelAttribute ("userDTO") UserDTO userDTO)
    {

        return "login";
    }

}
