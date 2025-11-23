package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.types.RiskType;
import com.codearp.patterns.abstractfactories.b_insurrance.domains.valueObjects.Audit;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Risk {

    @EqualsAndHashCode.Include
    private Long id;

    private RiskType riskType;

    private String description;

    private Audit audit;

}
