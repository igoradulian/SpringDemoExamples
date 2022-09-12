package com.learning.demo.entity.manytomany;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
