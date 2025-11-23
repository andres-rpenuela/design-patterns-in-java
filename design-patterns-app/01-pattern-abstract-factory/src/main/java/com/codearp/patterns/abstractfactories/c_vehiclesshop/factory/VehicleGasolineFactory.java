package com.codearp.patterns.abstractfactories.c_vehiclesshop.factory;

import com.codearp.vehicleshop.domain.Automobile;
import com.codearp.vehicleshop.domain.Scooter;
import com.codearp.vehicleshop.domain.gasoline.AutomobileGasoline;
import com.codearp.vehicleshop.domain.gasoline.ScooterGasoline;

public class VehicleGasolineFactory implements VehicleFactory {

    @Override
    public Automobile createAutomobile() {
        return new AutomobileGasoline();
    }

    @Override
    public Scooter createScooter() {
        return new ScooterGasoline();
    }
}
