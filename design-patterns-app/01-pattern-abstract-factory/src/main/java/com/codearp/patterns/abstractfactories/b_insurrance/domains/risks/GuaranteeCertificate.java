package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GuaranteeCertificate {

    private Long id;

    private String certificateNumber;
    private LocalDate issueDate;
    private Double amount;

    private String description; // opcional
}