package com.codearp.pattern.builder.a_shapes.domains.pyramidal;


/**
 * Calcula el área de la superficie considerando una base cuadrada y las caras triangulares.
 */
public class SquarePyramid extends PyramidalShape {

    private double baseSideLength;

    public SquarePyramid(double baseSideLength, double height) {
        setBaseArea(baseSideLength * baseSideLength);
        setHeight(height);
        this.baseSideLength = baseSideLength;
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(baseSideLength / 2, 2) + Math.pow(getHeight(), 2));
        return getBaseArea() + 2 * baseSideLength * slantHeight;
    }
}