package com.learning.demo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * This is example of
 * basic entity class which
 * database use fro CRUD
 * operations. @Table and @Column
 * annotations are totally optional.
 * They used if developer want specify
 * name of table or column in database.
 * Otherwise JPA use name of the class members
 * for columns and class name for table.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/*
To avoid of creation
some specific constructor it
is possible to use lombok
@RequiredArgsConstructor.
In this case the fields we want
to include in constructor should
be annotated as  @NonNull
 */
@RequiredArgsConstructor
@ToString
@Table(name = "guests")//Optional
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "phone")
    private String phoneNumber;

    @NonNull
    @Column(name = "room")
    private int room;

}
