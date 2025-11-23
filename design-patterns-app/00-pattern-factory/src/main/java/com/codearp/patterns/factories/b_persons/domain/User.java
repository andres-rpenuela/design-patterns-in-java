package com.codearp.patterns.factories.b_persons.domain;


import com.codearp.patterns.factories.b_persons.domain.shared.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

// Con esta configuración, dos objetos User serán considerados iguales si tienen el mismo email o el mismo nickname.
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends Person {
    @EqualsAndHashCode.Include
    private String email;

    @EqualsAndHashCode.Include
    private String nickname;

    private String password;
    private boolean active;

    private Auditable auditable;
}
