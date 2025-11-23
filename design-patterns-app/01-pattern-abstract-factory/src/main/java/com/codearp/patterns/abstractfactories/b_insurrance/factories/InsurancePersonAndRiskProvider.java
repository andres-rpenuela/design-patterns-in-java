package com.codearp.patterns.abstractfactories.b_insurrance.factories;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.risks.Risk;

public class InsurancePersonAndRiskProvider {

    public static Person createPerson(String type, Object ... params) {
        PersonFactory personFactory = new PersonFactory();

        return switch (type.toLowerCase()) {
            case "holder" -> personFactory.createdHolder();
            case "mediator" -> personFactory.createdMediator();
            case "person" -> personFactory.createdPerson();
            case "staff" -> personFactory.createdStaff();
            default -> null;
        };

    }

    public static Risk createRisk(String type, Object ... params) {
        RiskFactory riskFactory = new RiskFactory();
        return switch (type.toLowerCase()) {
            case "home" -> riskFactory.createdRiskHome();
            case "person" -> riskFactory.createdRiskPerson();
            case "strengthening" -> riskFactory.createRiskStrengthening();
            case "vehicle" -> riskFactory.createRiskVehicle();
            case "vehicle_person" -> riskFactory.createRiskVehiclePerson();

            default -> null;
        };
    }
}
