package com.learning.demo.repository;

import com.learning.demo.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    public Optional <Guest> findGuestByPhoneNumber(String phone);
    public Optional <Guest> findGuestByRoom(int room);
}
