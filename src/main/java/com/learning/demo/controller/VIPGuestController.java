package com.learning.demo.controller;

import com.learning.demo.dto.VipGuestDTO;
import com.learning.demo.entity.onetomany.VipGuest;
import com.learning.demo.repository.VipGuestRepository;
import com.learning.demo.service.VipGuestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * VipGuestController
 * demonstrates Data Transfer
 * Objects in work. DTOs
 * is layer of abstraction
 * which make use of Restcontrollers
 * easier
 * @author Igor Adulyan
 */
@RestController
public class VIPGuestController {

    private VipGuestService vipGuestService;

    @Autowired
    public VIPGuestController(VipGuestService vipGuestService) {
        this.vipGuestService = vipGuestService;
    }

    @PostMapping("/addVipGuest")
    public ResponseEntity<?> createVipGuest(@RequestBody VipGuestDTO vipGuestDTO)
    {
        vipGuestService.createVipGuest(vipGuestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vip Guest Created");
    }

    @GetMapping("/getVipGuest")
    public ResponseEntity<?> getVipGuest(@RequestParam(name = "phoneNumber") String phoneNumber)
    {
        VipGuestDTO vipGuestDTO = vipGuestService.getVipGuest(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(vipGuestDTO);
    }
}
