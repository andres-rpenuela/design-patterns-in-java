package com.codearp.patterns.abstractfactories.b_insurrance.factories;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.risks.*;

public class RiskFactory {

    Risk createdRiskHome(){
        return RiskHome.builder().build();
    };

    Risk createdRiskPerson(){
        return RiskPerson.builder().build();
    }

    Risk createRiskStrengthening(){
        return RiskStrengthening.builder().build();
    }

    Risk createRiskVehicle(){
        return RiskVehiclePerson.builder().build();
    }

    Risk createRiskVehiclePerson(){
        return RiskVehiclePerson.builder().build();
    }

    Risk createdRiskGuaranty(){
        return RiskGuarantee.builder().build();
    }
}
