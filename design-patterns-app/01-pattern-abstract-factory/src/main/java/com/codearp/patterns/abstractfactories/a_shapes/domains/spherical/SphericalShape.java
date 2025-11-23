package com.codearp.patterns.abstractfactories.a_shapes.domains.spherical;


import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class SphericalShape  extends Shape {

    protected double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}