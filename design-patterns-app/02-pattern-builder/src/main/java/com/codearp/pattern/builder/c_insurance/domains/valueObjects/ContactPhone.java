package com.codearp.pattern.builder.c_insurance.domains.valueObjects;

import com.codearp.pattern.builder.c_insurance.domains.types.CountryCode;
import com.codearp.pattern.builder.c_insurance.domains.types.PhoneType;

public class ContactPhone implements Cloneable{

    private CountryCode countryCode;
    private PhoneType phoneType;
    private String number;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
