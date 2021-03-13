package com.octopus.functionalUnitManagement.repository.interfaces;

import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FunctionalUnitRepository extends MongoRepository<FunctionalUnit, String> {
}
