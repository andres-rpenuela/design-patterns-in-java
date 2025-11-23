package com.codearp.patterns.abstractfactories.b_insurrance.factories;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Holder;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Staff;

public class PersonFactory {
    Person createdHolder(){
        return Holder.builder().build();
    };
    Person createdPerson(){
        return Person.builder().build();
    };
    Person createdStaff(){
        return Staff.builder().build();
    };
}
