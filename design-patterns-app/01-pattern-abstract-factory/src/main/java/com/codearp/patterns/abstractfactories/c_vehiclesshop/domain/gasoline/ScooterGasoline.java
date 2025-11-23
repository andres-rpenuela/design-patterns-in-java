package com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.gasoline;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Scooter;

public class ScooterGasoline extends Scooter {
    @Override
    public void characteristics() {
        System.out.println("Scooter gasoline, "+super.toString());
    }
}
