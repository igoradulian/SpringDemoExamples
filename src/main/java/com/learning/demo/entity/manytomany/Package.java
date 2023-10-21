package com.learning.demo.entity.manytomany;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "packageSet")
    @Getter(AccessLevel.NONE)
    private Set<Amenities> amenitiesSet;

    private String packageName;

    private String packageCode;

}
