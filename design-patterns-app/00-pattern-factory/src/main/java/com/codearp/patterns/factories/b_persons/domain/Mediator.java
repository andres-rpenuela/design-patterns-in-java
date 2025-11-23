package com.codearp.patterns.factories.b_persons.domain;

import com.codearp.patterns.factories.b_persons.domain.shared.Auditable;
import com.codearp.patterns.factories.b_persons.shareds.types.INSURANCE_SECTOR;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Mediator extends Person {

    @EqualsAndHashCode.Include
    private String email;

    private INSURANCE_SECTOR[] insuranceSectors;

    private String office;

    @EqualsAndHashCode.Include
    private long code;

    private long subCode;

    private String numberBankAccount;

    private String address;

    private boolean active;

    private Auditable auditable;
}
