package com.learning.demo.controller;

import com.learning.demo.dto.GuestDTO;
import com.learning.demo.entity.Guest;
import com.learning.demo.service.GuestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

/**
 * Note: if it is possible avoid
 * to use repository methods in
 * controllers directly. Always use
 * them through Service logic.
 *
 * This example use model mapper
 * to show how can easily one class
 * to be converted to other. For
 * now you don't need to know
 * all details abou model mapper.
 * However model mapper is tool
 * you will use a lot in industry
 */
@RestController
@RequestMapping(GuestController.ApiRoutes.GUESTS)
public class GuestController {

    public static class ApiRoutes {
        public static final String GUESTS = "/api/v1/guests";
    }


    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<?> createGuest(@RequestBody GuestDTO guestDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        /*
        Model mapper is using java reflection and map object fields
        of one class to the other by matching fields names.
        For instance both Guest and GuestDTO classes have
        "firstName" class field model mapper get data
        from GuestDTO "firstName and pass set it to the field
        with the same name in Guest class. This eliminates
        need to write setter getter methods
         */
        Guest guest = modelMapper.map(guestDTO, Guest.class);
        guestService.createGuest(guest);

        /*
        Response entity class allow us to configure response and provide
        custom object or message we want return
         */
        return ResponseEntity.status(HttpStatus.CREATED).body("Guest created");
    }

    /**
     * Find guest using
     * path variable
     * @param id
     * @return
     * @throws ChangeSetPersister.NotFoundException
     */
    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return guestService.findById(Integer.parseInt(id));
    }

    /**
     * Find Guest using
     * RequestParam class
     * @param id
     * @param guestDTO
     * @return
     */
    @PutMapping
            public Guest updateGuest(@RequestParam(name = "id") String id,
                                     @RequestBody GuestDTO guestDTO) throws ChangeSetPersister.NotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Guest guest = modelMapper.map(guestDTO, Guest.class);
        guest.setId(Integer.parseInt(id));

        //Return updated guest
        return guestService.updateGuest(guest);
    }
}
