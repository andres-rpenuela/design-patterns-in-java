package com.codearp.pattern.builder.b_vehiclesshop.builder;


import com.codearp.pattern.builder.b_vehiclesshop.domain.Document;

public interface DocumentVehicleBuilder {

    void createOrderDocument(String nameClient);
    void createEnrollmentDocument(String nameRequest);
    Document getResult();
}
