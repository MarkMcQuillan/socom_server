package com.lit.event.planner.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String id) {
        super("Employee "+id+" does not exist on Database");
    }

}