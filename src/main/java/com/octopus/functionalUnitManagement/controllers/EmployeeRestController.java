package com.octopus.functionalUnitManagement.controllers;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.service.interfaces.IEmployeeGatewayService;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
