package com.lit.event.planner.events.controllers;

import com.lit.event.planner.events.EventRegistrationRepository;
import com.lit.event.planner.events.exception.EventRegistrationNotFoundException;
import com.lit.event.planner.events.model.EventRegistration;
import com.lit.event.planner.events.services.EventRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.List;

// TODO: Extend model and database schema with EventRegistrations
// TODO: Add EventRegistrationRepository
// TODO: Use repository here to find eventRegistrations



@RestController
@RequestMapping("eventRegistrations")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository ;

    @Autowired
    private EventRegistrationService eventRegistrationService;

    //CONTROLLER FOR GET ALL
    @GetMapping()
    public List<EventRegistration> getAllEventRegistrations(){
        return eventRegistrationService.getAllRegistrations();
    }

    //CONTROLLER FOR GET ALL BY ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public EventRegistration getEventRegistration(@PathVariable ("id") int id){
        return  eventRegistrationService.getRegistration(id)
                .orElseThrow(() -> new EventRegistrationNotFoundException(id));
    }

    //CONTROLLER FOR ADDING
    @RequestMapping(method= RequestMethod.POST, value = "/eventRegistration")
    public void addEventRegistration(@RequestBody EventRegistration eventRegistration){
        eventRegistrationService.addRegistration((eventRegistration));
    }

    //CONTROLLER FOR DELETION
    @DeleteMapping("/{id}")
    public void deleteEventRegistration(@PathVariable int id){
        eventRegistrationService.deleteRegistration(id);
    }

    //CONTROLLER FOR UPDATING
    @PutMapping("/{id}")
    public ResponseEntity<EventRegistration> updateEventRegistration(@PathVariable(value = "id") int id,
                                             @Valid @RequestBody EventRegistration eventRegistrationDetails) throws EventRegistrationNotFoundException {
        EventRegistration eventRegistration = eventRegistrationRepository.findById(id)
                .orElseThrow(() -> new EventRegistrationNotFoundException(id));

        eventRegistration.setEmployeeID(eventRegistrationDetails.getEmployeeID());
        eventRegistration.setEventID(eventRegistration.getEventID());
        eventRegistration.setDate(eventRegistration.getDate());
        eventRegistration.setGuestFeePaid(eventRegistration.isGuestFeePaid());
        eventRegistration.setGuestID(eventRegistration.getGuestID());

        final EventRegistration updatedEventRegistration = eventRegistrationRepository.save(eventRegistration);
        return ResponseEntity.ok(updatedEventRegistration);
    }



}
