package com.lit.event.planner.events.services;

import com.lit.event.planner.events.EventRegistrationRepository;
import com.lit.event.planner.events.controllers.EventRegistrationController;
import com.lit.event.planner.events.model.EventRegistration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventRegistrationService {

    @Autowired
    EventRegistrationRepository eventRegistrationRepository;

    @Autowired
    EventRegistrationController eventRegistrationController;

    public List<EventRegistration> getAllRegistrations() {
        List<EventRegistration> registrations = new ArrayList<>();
        eventRegistrationRepository.findAll()
                .forEach(registrations::add);
        return registrations;
    }

    //return specified registration
    public Optional<EventRegistration> getRegistration(int id) {
        return eventRegistrationRepository.findById(id);
    }

    //adds registration
    public void addRegistration(EventRegistration registration) {
        eventRegistrationRepository.save(registration);
    }


    //update registration
    public void updateRegistration(int id, EventRegistration registration) {
        eventRegistrationRepository.save(registration);
    }

    //delete event (cancel)
    public void deleteRegistration(int id){
        eventRegistrationRepository.deleteById(id);
    }

}
