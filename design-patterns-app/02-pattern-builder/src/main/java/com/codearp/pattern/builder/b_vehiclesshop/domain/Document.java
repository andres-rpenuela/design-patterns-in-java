package com.codearp.pattern.builder.b_vehiclesshop.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Document {

    protected List<String> content;

    public Document(){
        this.content = new ArrayList<>();
    }

    public abstract void addDocument(String document);
    public abstract void printDocument();
}
