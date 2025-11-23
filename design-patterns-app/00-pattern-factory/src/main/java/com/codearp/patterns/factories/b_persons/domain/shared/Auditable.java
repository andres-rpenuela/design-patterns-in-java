package com.codearp.patterns.factories.b_persons.domain.shared;

import com.codearp.patterns.factories.b_persons.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Builder
@Data
@EqualsAndHashCode(exclude = {"createAt", "updateAt", "createdBy"})
public final class Auditable {
    private LocalDate createAt;
    private LocalDate updateAt;
    private String createdBy;
}
