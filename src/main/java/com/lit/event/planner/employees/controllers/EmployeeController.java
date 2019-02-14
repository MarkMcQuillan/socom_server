package com.lit.event.planner.employees.controllers;


import com.lit.event.planner.employees.data.EmployeeRepository;
import com.lit.event.planner.employees.exceptions.EmployeeNotFoundException;
import com.lit.event.planner.employees.model.Employee;
import com.lit.event.planner.employees.services.EmployeeService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
private EmployeeRepository employeeRepository;


   @GetMapping()
   public List<Employee> getEmployees(){
       return employeeService.getAllEmployees();
   }



    @GetMapping(value = "/{id}", produces = "application/json")
    public Employee getEmployee(@PathVariable ("id") String id){
        return  employeeService.getEmployee(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //CONTROLLER FOR DELETION
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }

   @RequestMapping(method=RequestMethod.POST, value = "/employees")
   public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee((employee));
   }

   @RequestMapping(method=RequestMethod.PUT, value = "/employees")
   public void updateEmployee(@RequestBody Employee employee, @PathVariable String id){
        /* */
        employeeService.updateEmployee(id, employee);
    }

    //CONTROLLER FOR UPDATING
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setSocomMember(employeeDetails.isSocomMember());

        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }





}
