package com.codearp.pattern.builder.a_shapes.domains.conical;


import com.codearp.pattern.builder.a_shapes.domains.Shape;

public abstract class ConicalShape  extends Shape {

    protected double radius;
    protected double height;

    protected ConicalShape(double radius, double height) {
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

}