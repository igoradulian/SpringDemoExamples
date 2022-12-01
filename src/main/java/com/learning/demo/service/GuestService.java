package com.learning.demo.service;

import com.learning.demo.entity.Guest;

import java.util.function.Function;

public interface GuestService {

    public String getGuestFullName(String phone);

    public boolean checkIfGuestHasARoom(String phone);

    public void createGuest(Guest guest);
}
