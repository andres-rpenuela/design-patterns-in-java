package com.codearp.patterns.abstractfactories.a_shapes.main;

import com.codearp.patterns.abstractfactories.a_shapes.domains.Shape;
import com.codearp.patterns.abstractfactories.a_shapes.factories.ShapeFactory;
import com.codearp.patterns.abstractfactories.a_shapes.factories.ShapeFactoryProvider;

public class MainShapeAbstractFactory {

    public static void main(String[] args) {
        // Crear una instancia del proveedor de fábricas
        ShapeFactory shapeFactory = new ShapeFactoryProvider();

        // Crear una forma cilíndrica sólida
        Shape solidCylinder = shapeFactory.createCylindricalShape(
                ShapeFactory.CylindricalType.SOLID, 5.0, 10.0);
        System.out.println("Cilindro sólido: " + solidCylinder);

        // Crear una forma cónica truncada (frustum)
        Shape frustumCone = shapeFactory.createConicalShape(
                ShapeFactory.ConicalType.FRUSTUM, 3.0, 5.0, 7.0);
        System.out.println("Cono truncado: " + frustumCone);

        // Crear una pirámide cuadrada
        Shape squarePyramid = shapeFactory.createPyramidalShape(
                ShapeFactory.PyramidalType.SQUARE, 4.0, 6.0);
        System.out.println("Pirámide cuadrada: " + squarePyramid);

        // Crear una pirámide triangular
        Shape triangularPyramid = shapeFactory.createPyramidalShape(
                ShapeFactory.PyramidalType.TRIANGULAR, 3.0, 5.0);
        System.out.println("Pirámide triangular: " + triangularPyramid);
    }
}