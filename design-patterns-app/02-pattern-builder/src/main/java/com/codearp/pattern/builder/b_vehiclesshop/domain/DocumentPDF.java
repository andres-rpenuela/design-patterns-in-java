package com.codearp.pattern.builder.b_vehiclesshop.domain;

public class DocumentPDF extends Document{

    @Override
    public void addDocument(String document) {
        if(document.startsWith("<PDF>")){
            this.content.add(document);
        }
        
    }

    @Override
    public void printDocument() {
        this.content.forEach(System.out::println);
    }
}
