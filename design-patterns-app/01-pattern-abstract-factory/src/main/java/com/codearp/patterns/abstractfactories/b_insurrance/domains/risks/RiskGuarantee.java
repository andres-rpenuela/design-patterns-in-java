package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter @Setter
public class RiskGuarantee extends Risk {

    private String guaranteeNumber;

    private Double amount;

    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private Person beneficiary;

    private Person guarantor; // opcional

    @Builder.Default
    private List<GuaranteeCertificate> certificates = new ArrayList<>();
}