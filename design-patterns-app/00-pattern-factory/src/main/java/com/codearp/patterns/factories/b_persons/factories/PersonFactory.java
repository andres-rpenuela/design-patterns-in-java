package com.codearp.patterns.factories.b_persons.factories;

import com.codearp.patterns.factories.b_persons.domain.Person;
import com.codearp.patterns.factories.b_persons.dtos.MediatorDto;
import com.codearp.patterns.factories.b_persons.dtos.UserDto;

public interface PersonFactory {
    Person createUser(UserDto userDto);
    Person createMediator(MediatorDto mediatorDto);

}
