package com.learning.demo.dto;

/**
 * @author Igor Adulyan
 */
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDTO {

    @Email
    private String login;

    @NotEmpty
    private String password;
}
