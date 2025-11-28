package com.codearp.pattern.builder.b_vehiclesshop.builder;

import com.codearp.pattern.builder.b_vehiclesshop.domain.Document;
import com.codearp.pattern.builder.b_vehiclesshop.domain.DocumentHtml;

import java.text.MessageFormat;

public class DocumentVehicleHTMLBuilder implements DocumentVehicleBuilder{
    private final Document document;

    public DocumentVehicleHTMLBuilder(){
        this.document = new DocumentHtml();
    }

    @Override
    public void createOrderDocument(String nameClient) {
        String documentOrder = MessageFormat.format("<HTML>Solicitud del pedido Cleinte: {0}.</HTML>",nameClient);

        this.document.addDocument(documentOrder);
    }

    @Override
    public void createEnrollmentDocument(String nameRequestOwn) {
        String documentOrder = MessageFormat.format("<HTML>Solicitud de la matriculacion, solicitante: {0}.</HTML>",nameRequestOwn);

        this.document.addDocument(documentOrder);
    }

    @Override
    public Document getResult() {
        return this.document;
    }
}
