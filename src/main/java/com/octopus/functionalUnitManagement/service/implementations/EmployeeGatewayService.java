package com.octopus.functionalUnitManagement.service.implementations;

import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;
import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.repository.interfaces.EmployeeRepository;
import com.octopus.functionalUnitManagement.repository.interfaces.ICustomQueryBuilder;
import com.octopus.functionalUnitManagement.service.interfaces.IEmployeeGatewayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeGatewayService implements IEmployeeGatewayService {
    @Autowired
    private IUtilityLogic utilityLogic;

    @Autowired
    private ICustomQueryBuilder customQueryBuilder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployeeProfile(Employee employee) {
        employee.setId("Emp_"+utilityLogic.IdGenerator());
        employee.setFullName(employee.getFirstName() + " " + employee.getLastName());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee(String name) {
        if (name == null)
            return employeeRepository.findAll();
        return customQueryBuilder.getEmployees(name);
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }
}
