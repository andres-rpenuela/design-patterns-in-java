package com.codearp.patterns.abstractfactories.a_shapes.domains.cylindrical;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class CylindricalShape  extends Shape {

    private double radius;
    private double height;

    public CylindricalShape(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract double volume();

    public abstract double surfaceArea();
}