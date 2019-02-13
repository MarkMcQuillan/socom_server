package com.lit.event.planner.events.controllers;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.model.Event;
import com.lit.event.planner.events.services.EventService;
import com.lit.event.planner.security.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;

// TODO: Extend model and database schema with Events
// TODO: Add EventRepository
// TODO: Use repository here to find events



@RestController
@RequestMapping("/api/events")
public class EventController {

@Autowired
   private EventRepository eventRepository ;

@Autowired
private EventService eventService;

    @RequestMapping("/event")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @RequestMapping("event/{id}")
    public Employee getEvent(@PathVariable int id){
        return null;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/event")
    public void addEvent(@RequestBody Event event){
        eventService.addEvent((event));
    }

}
