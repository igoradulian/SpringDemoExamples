package com.learning.demo.service;

import com.learning.demo.dto.AmenitiesDTO;
import com.learning.demo.dto.PackageDTO;
import com.learning.demo.entity.manytomany.Amenities;
import com.learning.demo.entity.manytomany.Package;
import com.learning.demo.repository.AmenitiesRepository;
import com.learning.demo.repository.PackageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Igor Adulyan
 */

@Service
public class AmenitiesServiceImpl implements AmenitiesService{

    private AmenitiesRepository amenitiesRepository;
    private PackageRepository packageRepository;

    public AmenitiesServiceImpl(AmenitiesRepository amenitiesRepository, PackageRepository packageRepository) {
        this.amenitiesRepository = amenitiesRepository;
        this.packageRepository = packageRepository;
    }

    @Override
    @Transactional
    public void createAmenities(AmenitiesDTO amenitiesDTO) {

        Set <PackageDTO> packageSetDTO = amenitiesDTO.getPackageSet();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        Amenities amenities = modelMapper.map(amenitiesDTO, Amenities.class);

        Set <Package> packageSet = new HashSet<>();
        for(PackageDTO p : packageSetDTO)
        {

            Package pack = modelMapper.map(p, Package.class);
            Package packSaved = packageRepository.save(pack);
            packageSet.add(packSaved);
            //
        }

        amenities.setPackageSet(packageSet);
        amenitiesRepository.save(amenities);
    }

    /**
     * In case of many to many relationship
     * it is complicated use lazy fetch with
     * real database id. It is more effective
     * avoid to use findById() in any type of
     * relationship and use some other unique
     * identifier. However, in this example
     * native query is used to get list of
     * package ids associated with amenities id
     * from join table
     * @See in PackageRepository
     *
     * @param code
     * @return
     */
    @Override
    @Transactional
    public AmenitiesDTO getAmenities(String code) {
       Amenities amenities = amenitiesRepository.findAmenitiesByAmenitiesCode(code);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        AmenitiesDTO amenitiesDTO = modelMapper.map(amenities, AmenitiesDTO.class);
        List<Integer> packageIdsList = packageRepository.getPackagesByAmenitiesId(amenitiesDTO.getId());

        Set<PackageDTO> packageSet = new HashSet<>();
        for (int id : packageIdsList)
            packageSet.add(modelMapper.map(packageRepository.findById(id).get(), PackageDTO.class));

        amenitiesDTO.setPackageSet(packageSet);

        return amenitiesDTO;
    }
}
