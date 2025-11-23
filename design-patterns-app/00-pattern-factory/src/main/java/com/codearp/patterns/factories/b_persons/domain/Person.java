package com.codearp.patterns.factories.b_persons.domain;

import com.codearp.patterns.factories.b_persons.shareds.types.TYPE_IDENTIFICATION;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Locale;

@Data
@SuperBuilder
@EqualsAndHashCode(exclude = { "lastName", "phoneNumber", "birthDate", "locale" })
public abstract class Person {
    private String name;
    private String lastName;
    private TYPE_IDENTIFICATION typeIdentification;
    private String identificationNumber;
    private String phoneNumber;
    private LocalDate birthDate;
    private Locale locale;
}
