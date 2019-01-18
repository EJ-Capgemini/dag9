package com.capgemini.dag9.controller;

import com.capgemini.dag9.model.Employee;
import com.capgemini.dag9.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addCar(@RequestBody Employee employee) {
        employeeService.save(employee);
    }
}
