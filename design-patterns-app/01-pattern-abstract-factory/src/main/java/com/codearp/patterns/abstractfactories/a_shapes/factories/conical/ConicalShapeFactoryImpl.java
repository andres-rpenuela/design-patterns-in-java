package com.codearp.patterns.abstractfactories.a_shapes.factories.conical;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;
import com.codearp.patterns.abstractfactories.a_shapes.domains.conical.Cone;
import com.codearp.patterns.abstractfactories.a_shapes.domains.conical.FrustumCone;

public class ConicalShapeFactoryImpl extends ConicalShapeFactory {

    @Override
    public Shape createConeShape(double radius, double height) {
        return new Cone(radius, height) {
        };
    }

    @Override
    public Shape createFrustrumShape(double topRadius, double bottomRadius, double height) {
        return new FrustumCone(topRadius, bottomRadius, height);
    }
}
