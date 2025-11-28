package com.codearp.pattern.builder.a_shapes.domains.conical;

public class FrustumCone extends ConicalShape {

    private double topRadius;

    public FrustumCone(double bottomRadius, double topRadius, double height) {
        super(bottomRadius, height);
        this.topRadius = topRadius;
    }

    public double getTopRadius() {
        return topRadius;
    }

    public void setTopRadius(double topRadius) {
        this.topRadius = topRadius;
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * getHeight() *
                (Math.pow(getRadius(), 2) + getRadius() * topRadius + Math.pow(topRadius, 2));
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(getRadius() - topRadius, 2) + Math.pow(getHeight(), 2));
        return Math.PI * (Math.pow(getRadius(), 2) + Math.pow(topRadius, 2) + slantHeight * (getRadius() + topRadius));
    }
}