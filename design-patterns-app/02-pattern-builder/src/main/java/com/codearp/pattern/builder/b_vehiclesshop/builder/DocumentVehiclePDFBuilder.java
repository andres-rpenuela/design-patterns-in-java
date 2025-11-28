package com.codearp.pattern.builder.b_vehiclesshop.builder;

import com.codearp.pattern.builder.b_vehiclesshop.domain.Document;
import com.codearp.pattern.builder.b_vehiclesshop.domain.DocumentPDF;

import java.text.MessageFormat;

public class DocumentVehiclePDFBuilder implements DocumentVehicleBuilder{
    private final Document document;

    public DocumentVehiclePDFBuilder(){
        this.document = new DocumentPDF();
    }

    @Override
    public void createOrderDocument(String nameClient) {
        String documentOrder = MessageFormat.format("<PDF>Solicitud del pedido Cleinte: {0}.</PDF>",nameClient);

        this.document.addDocument(documentOrder);
    }

    @Override
    public void createEnrollmentDocument(String nameRequestOwn) {
        String documentOrder = MessageFormat.format("<PDF>Solicitud de la matriculacion, solicitante: {0}.</PDF>",nameRequestOwn);

        this.document.addDocument(documentOrder);
    }

    @Override
    public Document getResult() {
        return this.document;
    }
}
