package com.codearp.patterns.abstractfactories.c_vehiclesshop;

import com.codearp.patterns.abstractfactories.c_vehiclesshop.service.CatalogService;

import java.util.Scanner;

public class VehicleMain {

    public static void main(String[] args) {
        CatalogService catalogService = new CatalogService();

        Scanner sc = new Scanner(System.in);
        int option = 1;
        while(option > 0){
            System.out.println("============================================");
            System.out.println("Operativas:");
            System.out.println("1. Generar Vehiculo");
            System.out.println("2. Ver vehiculos de gasolina.");
            System.out.println("3. Ver vehiculos elctricos");
            System.out.println("4. Salir");
            System.out.print("Que desea hacer: ");
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1 -> catalogService.generateVehicle();
                    case 2 -> catalogService.printGasoline();
                    case 3 -> catalogService.printElectrics();
                    case 4 -> option = 0;
                    default -> {
                        System.err.println("Opcion no valida.");
                        option = 5;
                    }
                };
            }
            catch(Exception e){
                System.err.println("No inserto un valor valido.");
                option = 5;
            }
        }
        sc.close();
    }
}
