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
public class AmenitiesController {


    private AmenitiesService amenitiesService;

    @Autowired
    public AmenitiesController(AmenitiesService amenitiesService) {
        this.amenitiesService = amenitiesService;
    }

    @PostMapping("/addAmenities")
    public ResponseEntity<?> addAmenities(@RequestBody AmenitiesDTO amenitiesDTO)
    {
        amenitiesService.createAmenities(amenitiesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Amenities Created");
    }

    @GetMapping("/getAmenities/{code}")
    public ResponseEntity<?> getAmenities(@PathVariable String code)
    {
       AmenitiesDTO amenitiesDTO = amenitiesService.getAmenities(code);

       return ResponseEntity.status(HttpStatus.OK).body(amenitiesDTO);
    }
}
