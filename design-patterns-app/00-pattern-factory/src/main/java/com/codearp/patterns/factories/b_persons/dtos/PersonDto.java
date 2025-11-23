package com.codearp.patterns.factories.b_persons.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Locale;

@Data
@SuperBuilder
@EqualsAndHashCode(exclude = { "lastName", "phoneNumber", "birthDate", "locale" })
public abstract  class PersonDto {

    private String name;
    private String lastName;
    private String typeIdentification;
    private String identificationNumber;
    private String phoneNumber;
    private LocalDate birthDate;
    private Locale locale;
}
