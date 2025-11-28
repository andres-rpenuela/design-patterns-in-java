package com.codearp.pattern.builder.c_insurance.domains.persons;

import com.codearp.pattern.builder.c_insurance.domains.types.Gender;
import com.codearp.pattern.builder.c_insurance.domains.types.Language;
import com.codearp.pattern.builder.c_insurance.domains.valueObjects.Audit;
import com.codearp.pattern.builder.c_insurance.domains.valueObjects.ContactPhone;
import com.codearp.pattern.builder.c_insurance.domains.valueObjects.IdentificationEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Cloneable{

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
    private Language language;

    @Builder.Default
    private List<ContactPhone> contactPhones = new ArrayList<>();
    private Audit audit;

    @Override
    public Object clone() throws CloneNotSupportedException  {
            Person cloned = (Person) super.clone();
            cloned.identification = (IdentificationEntity) this.identification.clone();
            contactPhones.stream().map(phone -> {
                try {
                    return (ContactPhone) phone.clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }).forEach(cloned.contactPhones::add);
            return cloned;
    }
}