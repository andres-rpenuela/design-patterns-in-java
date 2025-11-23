package com.codearp.patterns.abstractfactories.b_insurrance.domains.persons;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.types.Gender;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.valueObjects.Audit;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.valueObjects.ContactPhone;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.valueObjects.IdentificationEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

    @EqualsAndHashCode.Include
    @ToString.Exclude
    private Long id;

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;
    private IdentificationEntity identification;
    private Gender gender;
    private String nationality;

    @Builder.Default
    private List<ContactPhone> contactPhones = new ArrayList<>();
    private Audit audit;

}