package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;


import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RiskStrengthening extends Risk {

    private Person guarantor; // persona que afianza

    private Person beneficiary; // a quien se garantiza

    @Builder.Default
    private List<GuaranteeCertificate> certificates = new ArrayList<>();
}
