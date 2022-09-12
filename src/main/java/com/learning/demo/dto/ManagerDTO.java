package com.learning.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
