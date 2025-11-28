package com.codearp.pattern.builder.a_shapes.domains.spherical;

import com.codearp.pattern.builder.a_shapes.domains.Shape;

public class SquarePyramid extends Shape {

    private double base;
    private double height;
    private double slantHeight;

    public SquarePyramid(double base, double height) {
        this.base = base;
        this.height = height;
        this.slantHeight = Math.sqrt(Math.pow((base / 2), 2) + Math.pow(height, 2));
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSlantHeight() {
        return slantHeight;
    }

    public void setSlantHeight(double slantHeight) {
        this.slantHeight = slantHeight;
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.pow(base, 2) * height;
    }

    @Override
    public double surfaceArea() {
        double baseArea = Math.pow(base, 2);
        double lateralArea = 2 * base * slantHeight;
        return baseArea + lateralArea;
    }
}
