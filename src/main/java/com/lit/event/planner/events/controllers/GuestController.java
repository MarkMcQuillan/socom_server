package com.lit.event.planner.events.controllers;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.GuestRepository;
import com.lit.event.planner.events.exception.EventNotFoundException;
import com.lit.event.planner.events.exception.GuestNotFoundException;
import com.lit.event.planner.events.model.Event;
import com.lit.event.planner.events.model.Guest;
import com.lit.event.planner.events.services.EventService;
import com.lit.event.planner.events.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Extend model and database schema with Events
// TODO: Add EventRepository
// TODO: Use repository here to find events



@RestController
@RequestMapping("events")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository ;

    @Autowired
    private GuestService guestService;

    //CONTROLLER FOR GET ALL
    @GetMapping()
    public List<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }

    //CONTROLLER FOR GET ALL BY ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public Guest getGuest(@PathVariable ("id") int id){
        return  guestService.getGuest(id)
                .orElseThrow(() -> new GuestNotFoundException(id));
    }

    //CONTROLLER FOR ADDING
    @RequestMapping(method= RequestMethod.POST, value = "/guest")
    public void addGuest(@RequestBody Guest guest){
        guestService.addGuest((guest));
    }

    //CONTROLLER FOR DELETION
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable int id){
        guestService.deleteGuest(id);
    }

    //CONTROLLER FOR UPDATING
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable(value = "id") int id,
                                             @Valid @RequestBody Guest guestDetails) throws GuestNotFoundException {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException(id));

        guest.setFirstName(guestDetails.getFirstName());
        guest.setLastName(guestDetails.getLastName());
        guest.setCreatedOn(guestDetails.getCreatedOn());
        guest.setGuestID(guestDetails.getGuestID());

        final Guest updatedGuest = guestRepository.save(guest);
        return ResponseEntity.ok(updatedGuest);
    }



}
