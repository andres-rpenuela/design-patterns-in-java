package com.codearp.patterns.abstractfactories.c_vehiclesshop.service;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Automobile;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.Scooter;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric.AutomobileElectric;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.electric.ScooterElectric;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.gasoline.AutomobileGasoline;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.domain.gasoline.ScooterGasoline;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.factory.VehicleElectricFactory;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.factory.VehicleFactory;
import com.codearp.patterns.abstractfactories.c_vehiclesshop.factory.VehicleGasolineFactory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogService {

    List<Automobile> automobiles;
    List<Scooter> scooters;
    private static final String TEXT_GENERIC = """
                        Que quieres:
                        1. {0}.
                        2. {1}.
                        Selecionar una opcion: """;
    public CatalogService(){
        automobiles = new ArrayList<>();
        scooters = new ArrayList<>();
    }

    public void generateVehicle(){
        Scanner sc = new Scanner(System.in);
        VehicleFactory factory = null;

        int choiceVehicle = 0;
        while(choiceVehicle <= 0){
            try {
                String enumVeichle = MessageFormat.format(TEXT_GENERIC,"Electrico","Gasolina");
                System.out.print(enumVeichle);
                choiceVehicle = sc.nextInt();
                factory = getFactory( choiceVehicle );
            }catch (Exception e){
                System.err.println("Opcion no encontrada");
                choiceVehicle = -1;
            }
        }
        choiceVehicle = 0;
        while(choiceVehicle <= 0){
            try {
                String enumVeichle = MessageFormat.format(TEXT_GENERIC,"Automovil","Scooter");
                System.out.print(enumVeichle);
                choiceVehicle = sc.nextInt();
                addVehicle(choiceVehicle,factory);
            }catch (Exception e){
                System.err.println("Opcion no encontrada");
                choiceVehicle = -1;
            }
        }

    }

    public void printElectrics(){
        automobiles.stream().filter(AutomobileElectric.class::isInstance).forEach(Automobile::characteristics);
        scooters.stream().filter(ScooterElectric.class::isInstance).forEach(Scooter::characteristics);

    }

    public void printGasoline(){
        automobiles.stream().filter(AutomobileGasoline.class::isInstance).forEach(Automobile::characteristics);
        scooters.stream().filter(ScooterGasoline.class::isInstance).forEach(Scooter::characteristics);
    }

    private VehicleFactory getFactory(int choiceFactory){
        return switch(choiceFactory) {
            case 1 -> new VehicleElectricFactory();
            case 2 -> new VehicleGasolineFactory();
            default -> throw new IllegalArgumentException("Chocie Factory: "+ choiceFactory+", not found!");
        };
    }

    private void addVehicle(int choiceFactory, VehicleFactory vehicleFactory){
        switch(choiceFactory) {
            case 1 -> automobiles.add( vehicleFactory.createAutomobile() );
            case 2 -> scooters.add( vehicleFactory.createScooter() );
            default -> throw new IllegalArgumentException("Chocie Factory: "+ choiceFactory+", not found!");
        };
    }
}
