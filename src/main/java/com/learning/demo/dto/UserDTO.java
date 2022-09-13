package com.learning.demo.dto;

import com.learning.demo.validation.FieldMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@FieldMatch.List( { @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")})
public class UserDTO {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String zip;

    @NotNull(message = "Required field")
    private String password;


    @NotNull(message = "is required")
    private String matchingPassword;
}
