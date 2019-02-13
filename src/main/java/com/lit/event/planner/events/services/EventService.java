package com.lit.event.planner.events.services;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.controllers.EventController;
import com.lit.event.planner.events.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

        @Autowired
        private EventRepository eventRepository;

        @Autowired
        private EventController eventController;

        //retrieves all events
        public List<Event> getAllEvents() {
            List<Event> events = new ArrayList<>();
            eventRepository.findAll()
                    .forEach(events::add);
            return events;
        }

        //return specified event
        public Optional<Event> getEvent(int id) {
            return eventRepository.findById(id);
        }

        //adds event
        public void addEvent(Event event) {
            eventRepository.save(event);
        }


        //update event
        public void updateEvent(int id, Event event) {
            eventRepository.save(event);
        }

        //delete event
        public void deleteEvent(int id){

            eventRepository.deleteById(id);
        }




    }


