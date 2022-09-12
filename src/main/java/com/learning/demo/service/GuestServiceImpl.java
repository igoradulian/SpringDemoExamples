package com.learning.demo.service;

import com.learning.demo.entity.Guest;
import com.learning.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Guest Service provides business
 * logic for guest entity
 * The type Guest service.
 * @author Igor Adulyan
 */
@Service
public class GuestServiceImpl implements GuestService{

    /**
     * The Guest repository.
     */
   private GuestRepository guestRepository;

    /**
     * Instantiates a new Guest service.
     *
     * @param guestRepository the guest repository
     */
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void createGuest(Guest guest) {
       if(guestRepository.findGuestByPhoneNumber(guest.getPhoneNumber()) == null )
           guestRepository.save(guest);
       else
           throw new RuntimeException("Guest already exist");

    }

    @Override
    public long numberOfGuests() {
        return guestRepository.count();
    }

    @Override
    public Guest findById(int id) throws ChangeSetPersister.NotFoundException {
        return guestRepository.findById(id).orElseThrow(()-> new RuntimeException("Guest Doesn't exist"));
    }

    @Override
    public Guest updateGuest(Guest guest) {
            if(guestRepository.existsById(guest.getId()))
               return guestRepository.save(guest);
            else
                throw new RuntimeException("Guest Doesn't exist");
    }

    @Override
    public Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest findByPhone(String phone) {
        return guestRepository.findGuestByPhoneNumber(phone);
    }
}
