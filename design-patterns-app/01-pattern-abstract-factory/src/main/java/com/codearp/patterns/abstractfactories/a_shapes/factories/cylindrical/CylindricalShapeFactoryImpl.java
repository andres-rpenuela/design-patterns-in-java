package com.codearp.patterns.abstractfactories.a_shapes.factories.cylindrical;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;
import com.codearp.patterns.abstractfactories.a_shapes.domains.cylindrical.Cylinder;
import com.codearp.patterns.abstractfactories.a_shapes.domains.cylindrical.HollowCylinder;

public class CylindricalShapeFactoryImpl extends CylindricalShapeFactory {

    @Override
    public Shape createCylinder(double radius, double height) {
        return new Cylinder(radius, height);
    }

    @Override
    public Shape createHollowCylinder(double innerRadius, double outerRadius, double height) {
        return new HollowCylinder(innerRadius, outerRadius, height);
    }

}
