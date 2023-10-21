package com.learning.demo.entity;

import jakarta.persistence.*;
import lombok.*;


/**
 * This entity class
 * doesn't use any extra
 * annotations like @Table
 * and @Column
 * Lombok @Data generates
 * getter/setter methods,
 * toString method, @EqualsAndHashCode,
 * @RequiredArgsConstructor
 */
@Entity
@Data
//In case of entity we need no argConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

}
