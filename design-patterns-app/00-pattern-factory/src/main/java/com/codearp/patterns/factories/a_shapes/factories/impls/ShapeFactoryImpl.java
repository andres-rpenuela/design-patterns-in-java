package com.codearp.patterns.factories.a_shapes.factories.impls;

import com.codearp.patterns.factories.a_shapes.domains.Circle;
import com.codearp.patterns.factories.a_shapes.domains.Rectangle;
import com.codearp.patterns.factories.a_shapes.domains.Shape;
import com.codearp.patterns.factories.a_shapes.domains.Triangle;
import com.codearp.patterns.factories.a_shapes.factories.ShapeFactory;

public class ShapeFactoryImpl implements ShapeFactory {

    @Override
    public Shape createCircle(double radius) {
        return new Circle(radius);
    }

    @Override
    public Shape createRectangle(double length, double width) {
        return new Rectangle(length, width);
    }

    @Override
    public Shape createTriangle(double base, double height) {
        return new Triangle(base, height);
    }
}
