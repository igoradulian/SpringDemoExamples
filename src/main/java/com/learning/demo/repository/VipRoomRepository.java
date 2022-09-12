package com.learning.demo.repository;

import com.learning.demo.entity.onetoone.VipRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipRoomRepository extends CrudRepository<VipRoom, Integer> {
}
