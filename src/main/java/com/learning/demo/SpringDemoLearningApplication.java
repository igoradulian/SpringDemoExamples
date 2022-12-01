package com.learning.demo;

import com.learning.demo.entity.Guest;
import com.learning.demo.entity.Manager;
import com.learning.demo.service.GuestService;
import com.learning.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Use CommandLineRunner
 * to run specific codes
 * on application run
 *
 */
@SpringBootApplication
public class SpringDemoLearningApplication implements CommandLineRunner {

    @Autowired
    GuestService guestService;

    @Autowired
    ManagerService managerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoLearningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initGuests();
        initManagers();
    }

    private void initGuests()
    {
        guestService.createGuest(new Guest("John", "Doe", "897-987-1234", 12, "vip"));
        guestService.createGuest(new Guest("Jack", "Black", "897-987-4567", 1, "standard"));
        guestService.createGuest(new Guest("James", "Smith", "897-987-0987", 7, "vip"));
        guestService.createGuest(new Guest("Dana", "White", "897-987-3445", 2,
                "standard"));
        guestService.createGuest(new Guest("Ana", "Smith", "897-987-4675", 0,
                "standard"));

    }

    private void initManagers()
    {
        managerService.createManager(new Manager("Sam", "Adams", "sam@hotel.com"));
        managerService.createManager(new Manager("Michael", "Doe", "mike@hotel.com"));
        managerService.createManager(new Manager("George", "Williams", "george@hotel.com"));
    }


}
