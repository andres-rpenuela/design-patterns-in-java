package com.codearp.patterns.abstractfactories.b_insurrance.domains.insurrance;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Person;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.types.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

    @EqualsAndHashCode.Include
    private Long id;

    private String username; // correo electrónico o login

    private String passwordHash; // almacenar el hash, no la contraseña

    private boolean active;

    private Person person; // vinculado a la persona real

    @Builder.Default
    private Set<Role> roles = new HashSet<>();
}
