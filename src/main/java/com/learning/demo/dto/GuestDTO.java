package com.learning.demo.dto;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
