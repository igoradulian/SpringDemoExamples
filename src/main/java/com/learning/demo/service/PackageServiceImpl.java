package com.learning.demo.service;

import com.learning.demo.entity.manytomany.Package;
import com.learning.demo.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService{

    private PackageRepository packageRepository;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public Package getPackageByCode(String code) {
        //TODO  implement yourself
        return null;
    }

    @Override
    public Package getByPackageId(int id) {
        return packageRepository.findById(id).orElseThrow( ()-> new RuntimeException("Package id not Found"));
    }

    @Override
    public List<Integer> getPackageByAmenitiesId(int id) {
        return packageRepository.getPackagesByAmenitiesId(id);
    }
}
