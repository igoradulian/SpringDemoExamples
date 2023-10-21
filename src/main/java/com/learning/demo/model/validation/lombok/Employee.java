package com.learning.demo.model.validation.lombok;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Basic Employee JavaBean
 * Using Validation and lombok annotations
 * @author Igor Adulyan
 */
@Setter //Generates setter methods
@Getter //Generates getter methods
@NoArgsConstructor //Generates no argument constructor
@EqualsAndHashCode // Overrides Equal and Hashcode methods
@AllArgsConstructor  // All arguments constructors
@ToString // Overrides toString method
public class Employee implements Serializable {

    private static final long serialVersionUID = 3441074386497280732L;

    @NotEmpty(message = "First Name Can't be Empty")
    private String firstName;

    @NotEmpty(message = "Last Name Can't be Empty")
    private String lastName;

    @Email
    private String email;

    @Size(min = 8,max = 20, message = "username should not be less then 8 and more then 20 characters")
    private String username;

    /**
     * In order to provide password
     * complexity restriction use regex or
     * create custom annotation
     */
    @Size(min = 8, message = "password should not be less then 8 characters")
   // @Pattern(regexp = "\^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\w\d\s:])([^\s]){8,16}", message = "Wrong Password Format")
    private String password;

}