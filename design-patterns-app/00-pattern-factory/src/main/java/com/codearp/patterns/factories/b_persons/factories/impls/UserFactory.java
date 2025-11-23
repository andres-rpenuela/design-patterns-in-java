package com.codearp.patterns.factories.b_persons.factories.impls;

import com.codearp.patterns.factories.b_persons.domain.Mediator;
import com.codearp.patterns.factories.b_persons.domain.Person;
import com.codearp.patterns.factories.b_persons.domain.User;
import com.codearp.patterns.factories.b_persons.domain.shared.Auditable;
import com.codearp.patterns.factories.b_persons.dtos.MediatorDto;
import com.codearp.patterns.factories.b_persons.dtos.UserDto;
import com.codearp.patterns.factories.b_persons.factories.PersonFactory;
import com.codearp.patterns.factories.b_persons.shareds.types.INSURANCE_SECTOR;
import com.codearp.patterns.factories.b_persons.shareds.types.TYPE_IDENTIFICATION;

import java.util.Arrays;

public class UserFactory implements PersonFactory {

    @Override
    public Person createUser(UserDto userDto) {
        TYPE_IDENTIFICATION identificationType = TYPE_IDENTIFICATION.valueOf( userDto.getTypeIdentification() );
        return User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .typeIdentification( identificationType )
                .identificationNumber(userDto.getIdentificationNumber())
                .phoneNumber(userDto.getPhoneNumber())
                .birthDate(userDto.getBirthDate())
                .locale(userDto.getLocale())
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .active(userDto.isActive())
                .auditable(userDto.getAuditable() != null ?
                        Auditable.builder()
                                .createdBy( userDto.getAuditable().getCreatedBy() )
                                .createAt(userDto.getAuditable().getCreateAt())
                                .updateAt(userDto.getAuditable().getUpdateAt())
                                .build()
                        : null)
                .build();
    }

    @Override
    public Person createMediator(MediatorDto mediatorDto) {
        TYPE_IDENTIFICATION identificationType = TYPE_IDENTIFICATION.valueOf( mediatorDto.getTypeIdentification() );
        INSURANCE_SECTOR[] insuranceSectors = (INSURANCE_SECTOR[]) Arrays.stream( mediatorDto.getInsuranceSectors() )
                .map(INSURANCE_SECTOR::valueOf).toArray();

        return Mediator.builder()
                .name(mediatorDto.getName())
                .lastName(mediatorDto.getLastName())
                .typeIdentification( identificationType )
                .identificationNumber(mediatorDto.getIdentificationNumber())
                .phoneNumber(mediatorDto.getPhoneNumber())
                .birthDate(mediatorDto.getBirthDate())
                .locale(mediatorDto.getLocale())
                .email(mediatorDto.getEmail())
                .insuranceSectors( insuranceSectors )
                .office(mediatorDto.getOffice())
                .code(mediatorDto.getCode())
                .subCode(mediatorDto.getSubCode())
                .numberBankAccount(mediatorDto.getNumberBankAccount())
                .address(mediatorDto.getAddress())
                .active(mediatorDto.isActive())
                .auditable(mediatorDto.getAuditable() != null ?
                        Auditable.builder()
                                .createdBy( mediatorDto.getAuditable().getCreatedBy() )
                                .createAt(mediatorDto.getAuditable().getCreateAt())
                                .updateAt(mediatorDto.getAuditable().getUpdateAt())
                                .build()
                        : null)
                .build();
    }
}
