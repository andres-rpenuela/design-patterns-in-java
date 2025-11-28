package com.codearp.pattern.builder.a_shapes.domains.cylindrical;

public class Cylinder extends CylindricalShape {

    public Cylinder(double radius, double height) {
        super(radius, height);
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(getRadius(), 2) * getHeight();
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + getHeight());
    }
}