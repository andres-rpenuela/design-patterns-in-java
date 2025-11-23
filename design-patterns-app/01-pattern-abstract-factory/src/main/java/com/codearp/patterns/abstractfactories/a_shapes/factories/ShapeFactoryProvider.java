package com.codearp.patterns.abstractfactories.a_shapes.factories;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;
import com.codearp.patterns.abstractfactories.a_shapes.factories.conical.ConicalShapeFactory;
import com.codearp.patterns.abstractfactories.a_shapes.factories.conical.ConicalShapeFactoryImpl;
import com.codearp.patterns.abstractfactories.a_shapes.factories.cylindrical.CylindricalShapeFactory;
import com.codearp.patterns.abstractfactories.a_shapes.factories.cylindrical.CylindricalShapeFactoryImpl;
import com.codearp.patterns.abstractfactories.a_shapes.factories.pyramidal.PyramidalShapeFactoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Abstract Facotry Provider to get different shapes
 */
public class ShapeFactoryProvider extends ShapeFactory {


    @Override
    public Shape createCylindricalShape(CylindricalType type, double... parameters) {
        CylindricalShapeFactoryImpl factory = new CylindricalShapeFactoryImpl();
        return switch (type) {
            case SOLID -> factory.createCylinder(parameters[0], parameters[1]);
            case HOLLOW -> factory.createHollowCylinder(parameters[0], parameters[1], parameters[2]);
        };
    }

    @Override
    public Shape createConicalShape(ConicalType type, double... parameters) {
        ConicalShapeFactoryImpl factory = new ConicalShapeFactoryImpl();
        return switch (type) {
            case SOLID -> factory.createConeShape(parameters[0], parameters[1]);
            case FRUSTUM -> factory.createFrustrumShape(parameters[0], parameters[1], parameters[2]);
        };
    }

    @Override
    public Shape createPyramidalShape(PyramidalType type, double... parameters) {
        PyramidalShapeFactoryImpl factory = new PyramidalShapeFactoryImpl();
        return switch (type) {
            case SQUARE -> factory.createSquarePyramidalShape(parameters[0], parameters[1]);
            case TRIANGULAR -> factory.createTriangularPyramidalShape(parameters[0], parameters[1]);
        };
    }
}