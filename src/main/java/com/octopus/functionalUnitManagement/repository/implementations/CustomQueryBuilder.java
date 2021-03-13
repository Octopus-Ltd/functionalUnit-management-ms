package com.octopus.functionalUnitManagement.repository.implementations;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.repository.interfaces.ICustomQueryBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomQueryBuilder implements ICustomQueryBuilder {

    private final MongoTemplate mongoTemplate;

    public CustomQueryBuilder(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Employee> getEmployees(String name) {
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(Criteria.where("firstName").regex(name),
                Criteria.where("lastName").regex(name)));
        return mongoTemplate.find(query, Employee.class);
    }

    @Override
    public List<FunctionalUnit> getWorkUnits(String workUnit, String subType) {
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(Criteria.where("unitName").regex(workUnit),
                Criteria.where("functionalArea").regex(subType)));
        return mongoTemplate.find(query, FunctionalUnit.class);
    }
}
