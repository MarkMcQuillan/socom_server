package com.lit.event.planner.employees.data;

import com.lit.event.planner.employees.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee, String> {
	Optional<Employee> findByEmployeeId(String employeeId);


}
