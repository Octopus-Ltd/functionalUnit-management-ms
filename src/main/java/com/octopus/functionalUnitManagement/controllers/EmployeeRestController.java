package com.octopus.functionalUnitManagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.service.interfaces.IEmployeeGatewayService;

@RestController
@RequestMapping
public class EmployeeRestController {

    @Autowired
    private IEmployeeGatewayService employeeGatewayService;

    @GetMapping(value = "/employee")
    List<Employee> getAllEmployees(@RequestParam(name = "name", required = false) String name) {
       return employeeGatewayService.getAllEmployee(name);
    }

    @GetMapping(value = "/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") String id) {
        return employeeGatewayService.getEmployeeById(id);
    }

    @PostMapping(value = "/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeGatewayService.createEmployeeProfile(employee);
    }
}
