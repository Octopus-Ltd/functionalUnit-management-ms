package com.octopus.functionalUnitManagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;

@RestController
@RequestMapping
public class FunctionalUnitRestController {

    @Autowired
    private IFunctionalUnitGatewayService functionalUnitGatewayService;

    /**
     * @param unitName -
     * @param subType -
     *
     **/
    @GetMapping(value = "/workUnit")
    List<FunctionalUnit> getAllWorkUnits(@RequestParam(name = "unitName", required = false) String unitName,
                                         @RequestParam(name = "subType", required = false) String subType) {
        return functionalUnitGatewayService.getAllUnits(unitName, subType);
    }

    @GetMapping(value = "/workUnit/{id}")
    public Optional<FunctionalUnit> getUnitById(@PathVariable("id") String id) {
        return functionalUnitGatewayService.getUnitById(id);
    }

    @PostMapping(value = "workUnit")
    public FunctionalUnit createWorkUnit(@RequestBody FunctionalUnit functionalUnit) {
        return functionalUnitGatewayService.createUnit(functionalUnit);
    }

    @PatchMapping(value = "/workUnit/{id}", consumes = "application/json-patch+json")
    public FunctionalUnit updateWorkUnit(@PathVariable("id") String id, @RequestBody JsonPatch payload) throws JsonPatchException {
        return functionalUnitGatewayService.updateUnit(id, payload);
    }

    @PostMapping(value = "/workUnit/{id}/assignParty/{employeeId}")
    public FunctionalUnit assignRelatedParty(@PathVariable("id") String id,  @PathVariable("employeeId") String employeeId) {
        return functionalUnitGatewayService.assignRelatedParty(id, employeeId);
    }

}
