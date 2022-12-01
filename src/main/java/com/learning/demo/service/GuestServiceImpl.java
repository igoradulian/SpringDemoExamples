package com.learning.demo.service;

import com.learning.demo.entity.Guest;
import com.learning.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class GuestServiceImpl implements GuestService{

    /**
     * This method use built-in Function
     * functional interface and can therefore
     * be used as the assignment target for a
     * lambda expression or method reference
     * @param phone
     * @return
     */

    private GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public String getGuestFullName(String phone) {

        Guest guest = guestRepository.findGuestByPhoneNumber(phone).orElseThrow(RuntimeException::new);
        Function <Guest, String> fullName = f -> f.getFirstName() + " " + f.getFirstName();
        return fullName.apply(guest);
    }

    @Override
    public void createGuest(Guest guest) {

        guestRepository.save(guest);
    }

    @Override
    public boolean checkIfGuestHasARoom(String phone) {

        Guest guest = guestRepository.findGuestByPhoneNumber(phone).orElseThrow(RuntimeException::new);
        Predicate <Guest> isEmpty = g -> (g.getRoom() != 0);
        return isEmpty.test(guest);
    }
}
