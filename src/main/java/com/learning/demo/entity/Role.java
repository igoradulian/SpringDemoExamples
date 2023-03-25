package com.learning.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;


/**
 * @author Igor Adulyan
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Role(String name) {
        this.name = name;
    }
}
