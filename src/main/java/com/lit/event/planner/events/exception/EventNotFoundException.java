package com.lit.event.planner.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(int id) {
        super("Employee "+id+" does not exist on Database");
    }

}