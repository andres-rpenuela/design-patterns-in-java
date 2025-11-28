package com.codearp.pattern.builder.c_insurance.domains.persons;


import com.codearp.pattern.builder.c_insurance.domains.types.StaffRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Staff extends Person {

    private String staffCode;

    private String position;

    private Staff supervisor; // Opcional
    private List<Staff> subordinates = new ArrayList<>(); // Opcional

    @Builder.Default
    private Set<StaffRole> roles = new HashSet<>();
}
