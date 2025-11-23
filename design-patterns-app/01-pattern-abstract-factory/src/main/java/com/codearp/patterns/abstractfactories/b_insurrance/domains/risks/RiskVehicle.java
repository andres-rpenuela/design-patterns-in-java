package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder

public class RiskVehicle extends Risk{

    private String plateNumber;
    private String typeUse;
    private String hasGarage;

    private String vehicleType;

    private LocalDate firstMatriculationDate;

    private String base7;

}
