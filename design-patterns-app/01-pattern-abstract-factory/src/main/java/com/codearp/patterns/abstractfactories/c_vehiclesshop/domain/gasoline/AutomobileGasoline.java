package com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.gasoline;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Automobile;

public class AutomobileGasoline extends Automobile {
    @Override
    public void characteristics() {
        System.out.println("Automobile gasoline, "+super.toString());
    }

}
