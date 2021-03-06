package com.lit.event.planner.events.controllers;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.exception.EventNotFoundException;
import com.lit.event.planner.events.model.Event;
import com.lit.event.planner.events.services.EventService;
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
public class EventController {

@Autowired
   private EventRepository eventRepository ;

@Autowired
private EventService eventService;

//CONTROLLER FOR GET ALL
    @GetMapping()
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    //CONTROLLER FOR GET ALL BY ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public Event getEvent(@PathVariable ("id") int id){
        return  eventService.getEvent(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    //CONTROLLER FOR ADDING
    @RequestMapping(method= RequestMethod.POST, value = "/event")
    public void addEvent(@RequestBody Event event){
        eventService.addEvent((event));
    }

    //CONTROLLER FOR DELETION
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }

    //CONTROLLER FOR UPDATING
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") int id,
                                                   @Valid @RequestBody Event eventDetails) throws EventNotFoundException {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        event.setDate(eventDetails.getDate());
        event.setGuestFee(eventDetails.getGuestFee());
        event.setInfo(eventDetails.getInfo());
        event.setLocale(eventDetails.getLocale());
        event.setTitle(eventDetails.getTitle());

        final Event updatedEvent = eventRepository.save(event);
        return ResponseEntity.ok(updatedEvent);
    }

//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") int eventID)
//            throws EventNotFoundException {
//        Event event = eventRepository.findById(eventID)
//                .orElseThrow(() -> new EventNotFoundException(eventID));
//
//        eventRepository.delete(event);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
