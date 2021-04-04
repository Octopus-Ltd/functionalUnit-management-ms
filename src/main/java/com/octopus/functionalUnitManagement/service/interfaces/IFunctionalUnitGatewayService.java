package com.octopus.functionalUnitManagement.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;


public interface IFunctionalUnitGatewayService {
    FunctionalUnit createUnit(FunctionalUnit functionalUnit);
    List<FunctionalUnit> getAllUnits(String unitName, String subType);
    Optional<FunctionalUnit> getUnitById(String id);

    FunctionalUnit updateUnit(String id, JsonPatch payload) throws JsonPatchException;

    FunctionalUnit assignRelatedParty(String id, String employeeId);
}	
