package com.learning.demo.service;

import com.learning.demo.SpringDemoLearningApplication;
import com.learning.demo.entity.manytomany.Amenities;
import com.learning.demo.entity.manytomany.Package;
import com.learning.demo.repository.AmenitiesRepository;
import com.learning.demo.repository.PackageRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootTest(classes = SpringDemoLearningApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AmenitiesServiceTest {

    @Autowired
    AmenitiesService amenitiesService;

    @Autowired
    PackageService packageService;

    @Autowired
    AmenitiesRepository amenitiesRepository;

    @Autowired
    PackageRepository packageRepository;

    @Test
    @Order(1)
    public void test_creat_amenities()
    {
        Amenities amenities = new Amenities();
        amenities.setAmenitiesCode("CMA1233");
        amenities.setAmenitiesType("Pool");

        Set<Package> packageSet = new HashSet<>();

        Package amenitiesPackage = new Package();
        amenitiesPackage.setPackageName("Free meal by the pool");
        amenitiesPackage.setPackageCode("PKG12233");

        packageRepository.save(amenitiesPackage);

        packageSet.add(amenitiesPackage);
        amenities.setPackageSet(packageSet);

        Amenities amenitiesSaved = amenitiesRepository.save(amenities);

        Assertions.assertNotNull(amenitiesSaved);

    }

    @Test
    @Order(2)
    public void test_find_packages_by_amenities_ids()
    {
        Amenities amenities = amenitiesRepository.findAmenitiesByAmenitiesCode("CMA1233");
        List<Integer> packageIDsList = packageRepository.getPackagesByAmenitiesId(amenities.getId());
        Assertions.assertTrue(packageIDsList.size() > 0);

        /**
         * This is basic example
         * of stream in Java
         * for more info
         * @see https://www.baeldung.com/java-8-streams
         */
        List <Package> packageList =packageIDsList.stream().map(packageAmenities -> {
            return  packageRepository.findById(packageAmenities).get();
        }).collect(Collectors.toList());

        Assertions.assertTrue(packageList.size() > 0);

    }
}
