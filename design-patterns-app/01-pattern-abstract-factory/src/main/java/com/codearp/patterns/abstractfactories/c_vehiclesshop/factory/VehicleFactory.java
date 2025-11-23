package com.codearp.patterns.abstractfactories.c_vehiclesshop.factory;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Automobile;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Scooter;

public interface VehicleFactory {
    Automobile createAutomobile();
    Scooter createScooter();
}
