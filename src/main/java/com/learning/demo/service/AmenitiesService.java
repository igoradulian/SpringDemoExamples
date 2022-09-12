package com.learning.demo.service;

import com.learning.demo.dto.AmenitiesDTO;
import com.learning.demo.entity.manytomany.Amenities;

public interface AmenitiesService {

    public void createAmenities(AmenitiesDTO amenities);
    public AmenitiesDTO getAmenities(String code);
}
