package com.codearp.patterns.factories.b_persons.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserDto extends PersonDto {

    @EqualsAndHashCode.Include
    private String email;

    @EqualsAndHashCode.Include
    private String nickname;

    private String password;
    private boolean active;

    private AuditableDto auditable;
}
