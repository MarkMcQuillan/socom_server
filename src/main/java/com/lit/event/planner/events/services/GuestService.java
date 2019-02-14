package com.lit.event.planner.events.services;

import com.lit.event.planner.events.GuestRepository;
import com.lit.event.planner.events.controllers.GuestController;
import com.lit.event.planner.events.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestController guestController;

    //retrieve all Guests
    public List<Guest> getAllGuests(){
        List<Guest> guests = new ArrayList<>();
        guestRepository.findAll()
                .forEach(guests::add);
        return guests;
    }

    //return specified event
    public Optional<Guest> getGuest(int id) {
        return guestRepository.findById(id);
    }

    //adds event
    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }


    //update event
    public void updateGuest(int id, Guest guest) {
        guestRepository.save(guest);
    }

    //delete event
    public void deleteGuest(int id){
        guestRepository.deleteById(id);
    }
}
