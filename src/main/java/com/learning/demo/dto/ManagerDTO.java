package com.learning.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/**
 * @author Igor Adulyan
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ManagerDTO {

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @Email
    private String email;
}
