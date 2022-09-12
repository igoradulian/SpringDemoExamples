package com.learning.demo.repository;

import com.learning.demo.entity.manytoone.VipGuestFeedBack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VipGuestFeedbackRepository extends CrudRepository<VipGuestFeedBack, Integer> {

    public List<VipGuestFeedBack> findVipGuestFeedBacksByVipGuest_Id(int id);
}
