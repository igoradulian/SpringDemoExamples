package com.learning.demo.repository;

import com.learning.demo.entity.manytomany.Amenities;
import com.learning.demo.entity.manytomany.Package;
import org.hibernate.annotations.NamedNativeQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * It is good practice to use
 * Strings or other
 * primitive datatype to fetch
 * data from database
 *
 */
@Repository
public interface AmenitiesRepository extends CrudRepository<Amenities, Integer> {

    public Amenities findAmenitiesByAmenitiesCode(String code);
}
