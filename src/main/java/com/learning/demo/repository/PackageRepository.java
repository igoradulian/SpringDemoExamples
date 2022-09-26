package com.learning.demo.repository;

import com.learning.demo.entity.manytomany.Package;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends CrudRepository<Package, Integer> {


    /**
     * Native query used
     * to access data in
     * jointable.
     * @param id
     * @return
     */
    @Query(value = "SELECT package_id FROM amnities_packages where amenities_id=:id", nativeQuery = true)
    List<Integer> getPackagesByAmenitiesId(@Param("id") int id);
}
