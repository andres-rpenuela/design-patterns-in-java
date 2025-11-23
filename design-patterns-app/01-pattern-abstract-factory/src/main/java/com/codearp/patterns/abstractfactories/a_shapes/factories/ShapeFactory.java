package com.codearp.patterns.abstractfactories.a_shapes.factories;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;

public abstract class ShapeFactory {
    public enum CylindricalType { SOLID, HOLLOW }
    public enum ConicalType { SOLID, FRUSTUM }
    public enum PyramidalType { SQUARE, TRIANGULAR }

    public abstract Shape createCylindricalShape(CylindricalType type, double... parameters);
    public abstract Shape createConicalShape(ConicalType type, double... parameters);
    public abstract Shape createPyramidalShape(PyramidalType type, double... parameters);
}