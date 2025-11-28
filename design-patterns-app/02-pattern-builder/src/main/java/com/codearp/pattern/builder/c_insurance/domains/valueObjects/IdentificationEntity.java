package com.codearp.pattern.builder.c_insurance.domains.valueObjects;


import com.codearp.pattern.builder.c_insurance.domains.types.IdentificationEntityType;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class IdentificationEntity implements Cloneable{

    public IdentificationEntityType identificationEntityType;;
    public String identificationNumber;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
