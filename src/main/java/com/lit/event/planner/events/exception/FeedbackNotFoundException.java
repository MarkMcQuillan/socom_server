package com.lit.event.planner.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FeedbackNotFoundException extends RuntimeException {
    public FeedbackNotFoundException(int id) {
        super("Feedback "+id+" does not exist on Database");
    }

}