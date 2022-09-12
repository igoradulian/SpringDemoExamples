package com.learning.demo.entity.manytomany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * This is the most simple
 * type if Many-To-Many relationship
 * In this case join table used as
 * intermediate table between Amenities
 * and Package. Join Table helps to connect
 * to or more ids together and create
 * relation between entities
 *@see https://www.baeldung.com/jpa-many-to-many
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   private String amenitiesType;

   private String amenitiesCode;

   @ManyToMany
   @JoinTable(name = "amnities_packages", joinColumns = @JoinColumn(name = "amenities_id"),
   inverseJoinColumns = @JoinColumn(name = "package_id"))
   @Getter(AccessLevel.NONE)
   private Set<Package> packageSet;
}
