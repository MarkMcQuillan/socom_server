package com.lit.event.planner.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(int id) {
        super("Guest "+id+" does not exist on Database");
    }

}