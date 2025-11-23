package com.codearp.patterns.factories.a_shapes.factories;

import com.codearp.patterns.factories.a_shapes.domains.Shape;

public interface ShapeFactory {
    Shape createCircle(double radius);
    Shape createRectangle(double length, double width);
    Shape createTriangle(double base, double height);
}
