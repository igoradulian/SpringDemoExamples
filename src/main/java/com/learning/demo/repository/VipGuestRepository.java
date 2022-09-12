package com.learning.demo.repository;

import com.learning.demo.entity.onetomany.VipGuest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipGuestRepository extends CrudRepository<VipGuest, Integer> {

    public VipGuest findByPhoneNumber(String phone);
}
