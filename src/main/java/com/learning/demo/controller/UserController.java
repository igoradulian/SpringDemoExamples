package com.learning.demo.controller;

import com.learning.demo.dto.LoginDTO;
import com.learning.demo.dto.UserDTO;
import com.learning.demo.entity.User;
import com.learning.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Igor Adulyan
 */
@Controller
@Slf4j
public class UserController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    private UserService userDetailsService;

    @Autowired
    public UserController(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    private String redirectToLogin()
    {
        return "redirect:/login";
    }


    @GetMapping("/sign-up")
    public String signUp(Model model)
    {
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }

    @PostMapping("/signup-process")
    public String signupProcess(@Valid @ModelAttribute ("userDto") UserDTO userDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            log.warn("Wrong attempt");
            return "sign-up";
        }
        userDetailsService.creat(userDTO);
        return "confirmation";
    }

    /**
     * In order to
     * make code more readable
     * it is good practice to
     * use special DTOs for login
     * It also make controllers
     * less dependent from entities
     * and separate validation from
     * jpa functionality
     * @return
     */
    @RequestMapping("/login")
    public String getLoginPage()
    {
        log.error("Login failed");
        return "login";
    }


    @RequestMapping("/home")
    public String getHome()
    {
        return "home";

    }

}
