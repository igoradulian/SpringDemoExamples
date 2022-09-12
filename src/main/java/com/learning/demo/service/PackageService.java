package com.learning.demo.service;

import com.learning.demo.entity.manytomany.Package;

import java.util.List;

public interface PackageService {

    public Package getPackageByCode(String code);

    public Package getByPackageId(int id);

    public List<Integer> getPackageByAmenitiesId(int id);

}
