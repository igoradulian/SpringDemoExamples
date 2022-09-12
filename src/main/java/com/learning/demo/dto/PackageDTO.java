package com.learning.demo.dto;

import com.learning.demo.entity.manytomany.Amenities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author Igor Adulyan
 */
@Getter
@Setter
@NoArgsConstructor
public class PackageDTO {

    private int id;
    private Set<Amenities> amenitiesSet;

    private String packageName;
    private String packageCode;
}
