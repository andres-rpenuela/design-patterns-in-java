package com.codearp.patterns.abstractfactories.a_shapes.factories.pyramidal;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;
import com.codearp.patterns.abstractfactories.a_shapes.domains.pyramidal.SquarePyramid;
import com.codearp.patterns.abstractfactories.a_shapes.domains.pyramidal.TriangularPyramid;

public class PyramidalShapeFactoryImpl extends PyramidalShapeFactory {


    @Override
    public Shape createSquarePyramidalShape(double baseSideLength, double height) {
        return new SquarePyramid(baseSideLength, height);
    }

    @Override
    public Shape createTriangularPyramidalShape(double baseSideLength, double height) {
        return new TriangularPyramid(baseSideLength, height);
    }
}
