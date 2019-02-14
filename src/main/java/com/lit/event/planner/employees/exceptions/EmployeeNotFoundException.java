package com.lit.event.planner.employees.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("Employee "+id+" does not exist on Database");
    }

}