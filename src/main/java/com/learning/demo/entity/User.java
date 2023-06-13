package com.learning.demo.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;

/**
 * @author Igor Adulyan
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String zip;

    private String password;

    private String userId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection <Role> roles;

    public User(String userName, String firstName, String lastName, String email, String phone, String zip, String password ) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
        this.password = password;

    }
}
