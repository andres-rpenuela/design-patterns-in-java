package com.codearp.pattern.builder.a_shapes.domains.pyramidal;

/**
 * presenta una pirámide con base triangular equilátera, calculando el área de la base y las caras triangulares.
 */
public class TriangularPyramid extends PyramidalShape {

    private double baseSideLength;

    public TriangularPyramid(double baseSideLength, double height) {
        setBaseArea((Math.sqrt(3) / 4) * Math.pow(baseSideLength, 2));
        setHeight(height);
        this.baseSideLength = baseSideLength;
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(baseSideLength / 2, 2) + Math.pow(getHeight(), 2));
        return getBaseArea() + 3 * (baseSideLength * slantHeight / 2);
    }
}