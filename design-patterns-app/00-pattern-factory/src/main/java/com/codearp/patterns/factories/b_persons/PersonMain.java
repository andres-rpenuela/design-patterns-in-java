package com.codearp.patterns.factories.b_persons;

import com.codearp.patterns.factories.b_persons.domain.Mediator;
import com.codearp.patterns.factories.b_persons.dtos.MediatorDto;
import com.codearp.patterns.factories.b_persons.factories.PersonFactory;
import com.codearp.patterns.factories.b_persons.factories.impls.UserFactory;

import java.time.LocalDate;

public class PersonMain {

    public static void main(String[] args) {
        System.out.println("Person Factory Pattern");

        MediatorDto mediatorDto = MediatorDto.builder()
                .name("John")
                .lastName("Doe")
                .typeIdentification("PASSPORT")
                .identificationNumber("123456789")
                .phoneNumber("555-1234")
                .birthDate(LocalDate.of(1990,3,2))
                .locale( new java.util.Locale("en", "US") )
                .identificationNumber("MED123456")
                .typeIdentification("PASSPORT")
                .build();

        PersonFactory personFactory = new UserFactory();
        Mediator mediator = (Mediator) personFactory.createMediator(mediatorDto);

        System.out.println(mediator);
    }
}
