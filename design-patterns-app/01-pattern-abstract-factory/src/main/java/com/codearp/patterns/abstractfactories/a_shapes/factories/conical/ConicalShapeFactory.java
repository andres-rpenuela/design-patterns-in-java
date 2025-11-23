package com.codearp.patterns.abstractfactories.a_shapes.factories.conical;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class ConicalShapeFactory {
    abstract Shape createConeShape(double radius, double height);
    abstract Shape createFrustrumShape(double topRadius, double bottomRadius, double height);
}
