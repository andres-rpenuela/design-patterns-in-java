package com.codearp.patterns.factories.a_shapes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
public class Triangle extends Shape {

    private double base;
    private double height;

    @Override
    public void draw() {
        System.out.println("Drawing a triangle with base: " + base + " and height: " + height);
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }

    @Override
    public double perimeter() {
        // Assuming an equilateral triangle for simplicity
        return 3 * base;
    }
}
