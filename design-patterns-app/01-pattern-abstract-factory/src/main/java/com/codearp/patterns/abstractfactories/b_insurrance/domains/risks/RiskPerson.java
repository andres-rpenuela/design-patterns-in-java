package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Holder;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder
public class RiskPerson extends Risk {

    Person person;
    Holder holder;
    private boolean isHolder;
}
