package com.codearp.patterns.abstractfactories.a_shapes.factories.pyramidal;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class PyramidalShapeFactory {
    abstract Shape createSquarePyramidalShape(double baseSideLength, double height);
    abstract Shape createTriangularPyramidalShape(double baseSideLength, double height);
}
