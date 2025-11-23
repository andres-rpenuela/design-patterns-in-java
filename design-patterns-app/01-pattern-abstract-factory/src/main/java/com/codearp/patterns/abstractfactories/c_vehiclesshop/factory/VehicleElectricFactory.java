package com.codearp.patterns.abstractfactories.c_vehiclesshop.factory;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Automobile;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Scooter;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric.AutomobileElectric;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric.ScooterElectric;

public class VehicleElectricFactory implements VehicleFactory{

    @Override
    public Automobile createAutomobile() {
        return new AutomobileElectric();
    }

    @Override
    public Scooter createScooter() {
        return new ScooterElectric();
    }
}
