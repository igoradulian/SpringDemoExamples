package com.learning.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


/**
 * @author Igor Adulyan
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GuestDTO {

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @Size(max = 50)
    private String phoneNumber;

    @NotEmpty
    private int room;
}
