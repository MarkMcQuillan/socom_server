package com.lit.event.planner.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EventRegistrationNotFoundException extends RuntimeException {
    public EventRegistrationNotFoundException(int id) {
        super("This registration "+id+" does not exist on Database");
    }

}