package com.octopus.functionalUnitManagement.repository.interfaces;

import com.octopus.functionalUnitManagement.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
