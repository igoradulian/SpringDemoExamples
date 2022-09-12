package com.learning.demo.dto;

import com.learning.demo.entity.manytomany.Package;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
/**
 * @author Igor Adulyan
 */
@Setter
@Getter
@NoArgsConstructor
public class AmenitiesDTO {

    private int id;

    private String amenitiesType;

    private String amenitiesCode;
    private Set<PackageDTO> packageSet;
}
