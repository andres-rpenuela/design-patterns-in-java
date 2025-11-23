package com.codearp.patterns.abstractfactories.a_shapes.domains.spherical;

public class Sphere extends SphericalShape {

    public Sphere(double radius) {
        setRadius(radius);
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(getRadius(), 2);
    }
}