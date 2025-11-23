package com.codearp.patterns.abstractfactories.c_vehiclesshop.domain;

public abstract class Automobile {
    protected String model;
    protected String color;
    protected int power;
    private double space;

    public Automobile() {
    }

    public Automobile(String model, String color, int power, double space) {
        this.model = model;
        this.color = color;
        this.power = power;
        this.space = space;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "characteristics: {" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", space=" + space +
                '}';
    }

    public abstract void characteristics();

}
