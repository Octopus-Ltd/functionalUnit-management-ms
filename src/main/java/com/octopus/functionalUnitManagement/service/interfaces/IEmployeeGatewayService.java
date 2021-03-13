package com.octopus.functionalUnitManagement.service.interfaces;

import com.octopus.functionalUnitManagement.models.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeGatewayService {

    Employee createEmployeeProfile(Employee employee);
    List<Employee> getAllEmployee(String name);
    Optional<Employee> getEmployeeById(String id);

}
