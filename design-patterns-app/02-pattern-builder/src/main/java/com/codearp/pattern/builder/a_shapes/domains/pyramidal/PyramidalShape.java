package com.codearp.pattern.builder.a_shapes.domains.pyramidal;


import com.codearp.pattern.builder.a_shapes.domains.Shape;

public abstract class PyramidalShape  extends Shape {

    protected double baseArea;
    protected double height;

    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return (1.0 / 3.0) * baseArea * height;
    }
}