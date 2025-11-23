package com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Automobile;

public class AutomobileElectric extends Automobile {
    @Override
    public void characteristics() {
        System.out.println("Scooter electric, "+super.toString());
    }
}
