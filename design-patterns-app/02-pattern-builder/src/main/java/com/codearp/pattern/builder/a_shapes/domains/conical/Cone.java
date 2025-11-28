package com.codearp.pattern.builder.a_shapes.domains.conical;

public class Cone extends ConicalShape {

    public Cone(double radius, double height) {
        super(radius, height); // Llama al constructor de ConicalShape
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(getRadius(), 2) * getHeight();
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(getRadius(), 2) + Math.pow(getHeight(), 2));
        return Math.PI * getRadius() * (getRadius() + slantHeight);
    }
}