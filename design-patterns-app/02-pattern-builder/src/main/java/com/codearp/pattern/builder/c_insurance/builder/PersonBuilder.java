package com.codearp.pattern.builder.c_insurance.builder;

import com.codearp.pattern.builder.c_insurance.domains.persons.Person;
import com.codearp.pattern.builder.c_insurance.domains.types.Gender;
import com.codearp.pattern.builder.c_insurance.domains.types.IdentificationEntityType;
import com.codearp.pattern.builder.c_insurance.domains.types.Language;
import com.codearp.pattern.builder.c_insurance.domains.valueObjects.IdentificationEntity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonBuilder {

    public static PersonBuilderNameStep builder() {
        return new PersonBuilderImpl();
    }

    public interface PersonBuilderNameStep {
        PersonBuilderEmailStep withName(String name);
    }

    public interface PersonBuilderEmailStep {
        PersonalIdentificationBuilderStep withEmail(String email);
    }

    public interface PersonalIdentificationBuilderStep {
        PersonBuilderSteps withPersonalIdentification(IdentificationEntityType personalIdentification, String personalIdentificationNumber);
    }

    public interface PersonBuilderSteps {
        PersonBuilderSteps withSurName(String surName);
        PersonBuilderSteps withGender(String gender);
        PersonBuilderSteps withLanguage(String language);
        PersonBuilderSteps withBirthDate(String birthDate);
        PersonBuilderSteps withNationality(String nationality);
        Person build();
    }

    private static class PersonBuilderImpl implements PersonBuilderNameStep,
            PersonBuilderEmailStep,
            PersonalIdentificationBuilderStep,
            PersonBuilderSteps {

        private final Person person;

        public PersonBuilderImpl() {
            this.person = new Person();
        }

        @Override
        public PersonBuilderEmailStep withName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
            }
            this.person.setName(name);
            return this;
        }

        @Override
        public PersonBuilderSteps withSurName(String surName) {
            if (surName == null || surName.isEmpty()) {
                throw new IllegalArgumentException("El apellido no puede ser nulo o vacío.");
            }
            this.person.setSurname(surName);
            return this;
        }

        @Override
        public PersonalIdentificationBuilderStep withEmail(String email) {
            this.person.setEmail( email );
            return this;
        }

        @Override
        public PersonBuilderSteps withGender(String gender) {
            try {
                this.person.setGender(Gender.valueOf(gender));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Género inválido: " + gender);
            }
            return this;
        }

        @Override
        public PersonBuilderSteps withLanguage(String language) {
            try {
                this.person.setLanguage(Language.valueOf(language));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Idioma inválido: " + language);
            }
            return this;
        }

        @Override
        public PersonBuilderSteps withBirthDate(String birthDate) {
            try {
                LocalDate date = LocalDate.parse(birthDate);
                this.person.setBirthDate(date);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Fecha de nacimiento inválida: " + birthDate);
            }
            return this;
        }

        @Override
        public PersonBuilderSteps withNationality(String nationality) {
            if (nationality == null || nationality.isEmpty()) {
                throw new IllegalArgumentException("La nacionalidad no puede ser nula o vacía.");
            }
            this.person.setNationality(nationality);
            return this;
        }

        @Override
        public PersonBuilderSteps withPersonalIdentification(IdentificationEntityType personalIdentificationType, String personalIdentificationNumber) {
            if (personalIdentificationType == null || personalIdentificationNumber == null || personalIdentificationNumber.isEmpty()) {
                throw new IllegalArgumentException("La identificación personal no puede ser nula o vacía.");
            }
            IdentificationEntity identification = IdentificationEntity.builder()
                    .identificationEntityType(personalIdentificationType)
                    .identificationNumber(personalIdentificationNumber)
                    .build();
            this.person.setIdentification(identification);
            return this;
        }

        @Override
        public Person build() {
            return this.person;
        }
    }
}