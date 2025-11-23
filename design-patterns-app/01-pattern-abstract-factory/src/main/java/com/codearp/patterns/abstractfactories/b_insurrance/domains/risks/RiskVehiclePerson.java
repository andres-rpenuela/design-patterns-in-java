package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder

public class RiskVehiclePerson extends Risk{

    private String plateNumber;
    private String vin;

    private boolean isOwnerPerson;
    private boolean isHabitualDriverPerson;
    private boolean isOccasionalDriverPerson;

    private LocalDate circulationCardIssueDate;
    private LocalDate circulationCardExpirationDate;
    private String typeCardCirculation;

    private Person person;

}
