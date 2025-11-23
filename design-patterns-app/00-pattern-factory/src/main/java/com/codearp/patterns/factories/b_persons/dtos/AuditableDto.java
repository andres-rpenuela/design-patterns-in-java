package com.codearp.patterns.factories.b_persons.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(exclude = { "createAt", "updateAt", "createdBy" })
public class AuditableDto {
    private LocalDate createAt;
    private LocalDate updateAt;
    private String createdBy;
}
