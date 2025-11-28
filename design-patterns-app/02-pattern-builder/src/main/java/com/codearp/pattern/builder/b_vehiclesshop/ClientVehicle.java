package com.codearp.pattern.builder.b_vehiclesshop;

import com.codearp.pattern.builder.b_vehiclesshop.domain.Document;
import com.codearp.pattern.builder.b_vehiclesshop.manager.Seller;
public class ClientVehicle {
    public static void main(String[] args) {
        Seller seller = new Seller();

        Document document1 = seller.order("pdf");
        Document document2 = seller.order("html");

        document1.printDocument();
        document2.printDocument();

    }
}