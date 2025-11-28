package com.codearp.pattern.builder.a_shapes.domains.spherical;

/**
 * Representa un hemisferio, calculando el volumen y el área de superficie correspondientes.
 */
public class Hemisphere extends SphericalShape {

    public Hemisphere(double radius) {
        setRadius(radius);
    }

    @Override
    public double volume() {
        return (2.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }

    @Override
    public double surfaceArea() {
        return 3 * Math.PI * Math.pow(getRadius(), 2);
    }
}