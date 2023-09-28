package com.learning.demo.service;

import com.learning.demo.SpringDemoLearningApplication;
import com.learning.demo.entity.Guest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Basic tests to check if
 * guest service business
 * logic works
 */

@SpringBootTest(classes = SpringDemoLearningApplication.class)
public class GuestsServiceTest {

    @Autowired
    GuestService guestService;

    @Test
    public void testGetAllGuests()
    {
        List<Guest> guestsList = (List<Guest>) guestService.getAllGuests();
        long totalGuests = guestService.numberOfGuests();

        Assertions.assertEquals(guestsList.size(), totalGuests);
    }

    /**
     * Hint:
     * Always try to avoid hard coding in tests
     * In future when you will make changes in
     * code you can easily reuse the same test
     * cases. Also consider different data
     * structures which you can use in tests
     * @throws ChangeSetPersister.NotFoundException
     */
    @Test
    public void testGetGuestsById() throws ChangeSetPersister.NotFoundException {

        ArrayList<Guest> guests = (ArrayList<Guest>) guestService.getAllGuests();
        //Linked List gives more flexibility and help avoid hardcoding
        LinkedList <Guest> guestsList = new LinkedList<>(guests);
        int expectedGuestId = guestsList.getFirst().getId();

        Guest guest = guestService.findById(expectedGuestId);

        Assertions.assertEquals(expectedGuestId, guest.getId());
    }
    


}
