package com.codearp.patterns.abstractfactories.a_shapes.domains.cylindrical;

public class HollowCylinder extends CylindricalShape {

    private double innerRadius;

    public HollowCylinder(double outerRadius, double innerRadius, double height) {
        super(outerRadius, height);
        this.innerRadius = innerRadius;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    @Override
    public double volume() {
        return Math.PI * getHeight() * (Math.pow(getRadius(), 2) - Math.pow(innerRadius, 2));
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * (Math.pow(getRadius(), 2) - Math.pow(innerRadius, 2))
                + 2 * Math.PI * getHeight() * (getRadius() + innerRadius);
    }
}