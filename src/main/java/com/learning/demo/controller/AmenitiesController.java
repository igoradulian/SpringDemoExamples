package com.learning.demo.controller;

import com.learning.demo.dto.AmenitiesDTO;
import com.learning.demo.entity.manytomany.Amenities;
import com.learning.demo.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Igor Adulyan
 */
@RestController
@RequestMapping(value = AmenitiesController.ApiRoutes.AMENITIES)
public class AmenitiesController {

    public static class ApiRoutes {
        public static final String AMENITIES = "/api/v1/amenities";
    }

    private AmenitiesService amenitiesService;

    @Autowired
    public AmenitiesController(AmenitiesService amenitiesService) {
        this.amenitiesService = amenitiesService;
    }

    @PostMapping
    public ResponseEntity<?> addAmenities(@RequestBody AmenitiesDTO amenitiesDTO)
    {
        amenitiesService.createAmenities(amenitiesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Amenities Created");
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getAmenities(@PathVariable String code)
    {
       AmenitiesDTO amenitiesDTO = amenitiesService.getAmenities(code);

       return ResponseEntity.status(HttpStatus.OK).body(amenitiesDTO);
    }
}
