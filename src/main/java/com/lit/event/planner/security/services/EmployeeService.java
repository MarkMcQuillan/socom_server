package com.lit.event.planner.security.services;

import com.lit.event.planner.security.controllers.EmployeeController;
import com.lit.event.planner.security.data.EmployeeRepository;
import com.lit.event.planner.security.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeController employeeController;

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

   public Optional<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
   }

   public void addEmployee(Employee employee){
        employeeRepository.save(employee);
   }


    public void updateEmployee(String id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id){

        employeeRepository.deleteById(id);
    }




}
