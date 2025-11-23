package com.codearp.patterns.abstractfactories.a_shapes.factories.cylindrical;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class CylindricalShapeFactory{
    abstract Shape createHollowCylinder(double outerRadius, double innerRadius, double height);
    abstract Shape createCylinder(double radius, double height);
}