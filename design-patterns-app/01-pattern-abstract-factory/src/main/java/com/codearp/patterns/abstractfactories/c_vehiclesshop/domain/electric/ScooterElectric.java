package com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Scooter;

public class ScooterElectric extends Scooter {
    @Override
    public void characteristics() {
        System.out.println("Scooter electric, "+super.toString());
    }
}
