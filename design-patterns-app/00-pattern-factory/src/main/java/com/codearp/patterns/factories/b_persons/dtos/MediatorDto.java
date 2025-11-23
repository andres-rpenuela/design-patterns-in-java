package com.codearp.patterns.factories.b_persons.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class MediatorDto extends PersonDto {

    @EqualsAndHashCode.Include
    private String email;

    private String[] insuranceSectors;

    private String office;

    @EqualsAndHashCode.Include
    private long code;

    private long subCode;

    private String numberBankAccount;

    private String address;

    private boolean active;

    private AuditableDto auditable;
}
