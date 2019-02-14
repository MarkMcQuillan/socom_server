package com.lit.event.planner.events.exception;

import com.lit.event.planner.events.model.EventRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EventRegistrationNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(EventRegistrationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String eventNotFoundHandler(EventRegistrationNotFoundException ex) {
        return ex.getMessage();
    }

}
