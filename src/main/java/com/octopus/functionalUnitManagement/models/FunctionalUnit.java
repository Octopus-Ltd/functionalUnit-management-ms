package com.octopus.functionalUnitManagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "com.octopus.functionalUnit.workUnit")
public class FunctionalUnit {
    @Id
    private String id;
    private String unitName;
    private Employee manager;
    private Employee unitLead;
    private List<String> functionalArea;
    private List<Employee> relatedParty;

    public FunctionalUnit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getUnitLead() {
        return unitLead;
    }

    public void setUnitLead(Employee unitLead) {
        this.unitLead = unitLead;
    }

    public List<String> getFunctionalArea() {
        return functionalArea;
    }

    public void setFunctionalArea(List<String> functionalArea) {
        this.functionalArea = functionalArea;
    }

    public List<Employee> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<Employee> relatedParty) {
        this.relatedParty = relatedParty;
    }
}
