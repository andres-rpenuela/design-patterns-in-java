package com.codearp.pattern.builder.b_vehiclesshop.domain;

public class DocumentHtml extends Document{

    @Override
    public void addDocument(String document) {
        if(document.startsWith("<HTML>")){
            this.content.add(document);
        }

    }

    @Override
    public void printDocument() {
        this.content.forEach(System.out::println);
    }
}
