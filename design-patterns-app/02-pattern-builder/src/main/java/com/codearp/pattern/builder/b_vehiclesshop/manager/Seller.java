package com.codearp.pattern.builder.b_vehiclesshop.manager;


import com.codearp.pattern.builder.b_vehiclesshop.builder.DocumentVehicleBuilder;
import com.codearp.pattern.builder.b_vehiclesshop.builder.DocumentVehicleHTMLBuilder;
import com.codearp.pattern.builder.b_vehiclesshop.builder.DocumentVehiclePDFBuilder;
import com.codearp.pattern.builder.b_vehiclesshop.domain.Document;

import java.util.Scanner;

public class Seller {
    private static final Scanner scanner = new Scanner(System.in);

    public Document order(String typeDocument){

        DocumentVehicleBuilder builder = switch (typeDocument.toLowerCase()) {
            case "pdf" -> new DocumentVehiclePDFBuilder();
            case "html" -> new DocumentVehicleHTMLBuilder();
            default -> throw new RuntimeException("Option not found");
        };


        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        //scanner.close();
        // steps
        builder.createOrderDocument(name);
        builder.createEnrollmentDocument(name);
        // result
        return builder.getResult();
    }
}
