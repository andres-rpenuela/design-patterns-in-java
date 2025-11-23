package com.codearp.patterns.abstractfactories.b_insurrance.domains.risks;

import com.codearp.patterns.abstractfactories.b_insurrance.domains.persons.Holder;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RiskHome extends Risk{

    private Double propertyValue;
    private Double contentValue;

    private List<InsuredAsset> assets = new ArrayList<>();

}
