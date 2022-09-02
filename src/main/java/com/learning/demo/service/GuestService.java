package com.learning.demo.service;

import com.learning.demo.entity.Guest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface GuestService {

    public void createGuest(Guest guest);
    public long numberOfGuests();
    public Guest findById(int id) throws ChangeSetPersister.NotFoundException;
    public Guest updateGuest(Guest guest);
    public Iterable<Guest> getAllGuests();

}
