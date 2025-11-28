package com.codearp.pattern.builder.c_insurance.manager;

import com.codearp.pattern.builder.c_insurance.builder.PersonBuilder;
import com.codearp.pattern.builder.c_insurance.domains.persons.Person;
import com.codearp.pattern.builder.c_insurance.domains.types.IdentificationEntityType;

public class Register {

    public Person registerPerson(){
        return PersonBuilder.builder()
                .withName("Juan")
                .withEmail("arp@test.com")
                .withPersonalIdentification(IdentificationEntityType.OTHER, "12345678")
                .withSurName("Perez")
                .build();
    }
}
