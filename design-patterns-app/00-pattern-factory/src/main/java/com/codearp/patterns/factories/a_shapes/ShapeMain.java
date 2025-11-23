package com.codearp.patterns.factories.a_shapes;

import com.codearp.patterns.factories.a_shapes.domains.Shape;
import com.codearp.patterns.factories.a_shapes.factories.ShapeFactory;
import com.codearp.patterns.factories.a_shapes.factories.impls.ShapeFactoryImpl;

import java.util.Scanner;

public class ShapeMain {

    public static void main(String[] args) {
        System.out.println("Factory Pattern - Shapes Example");

        Scanner sc = new Scanner(System.in);
        Shape shape = null;
        int option = 0;
        ShapeFactory shapeFactory = new ShapeFactoryImpl();
        do {
            try {
                System.out.println("1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Triangle");
                System.out.println("4. Exit");
                System.out.print("Select the shape to create:");

                option = Integer.parseInt(System.console().readLine());

                shape = switch ( option ){
                    case 1 -> shapeFactory.createCircle(5);
                    case 2 -> shapeFactory.createRectangle(4, 6);
                    case 3 -> shapeFactory.createTriangle(4, 5);
                    case 4 -> {
                        System.out.println("Exiting...");
                        yield null;
                    }
                    default -> throw new IllegalArgumentException("Invalid option");
                };

                if (shape != null) {
                    shape.draw();
                    System.out.println("Area: " + shape.area());
                    System.out.println("Perimeter: " + shape.perimeter());

                    if( shape instanceof com.codearp.patterns.factories.a_shapes.domains.Rectangle rectangle ){
                        boolean isSquare = ((com.codearp.patterns.factories.a_shapes.domains.Rectangle) rectangle).isSquare();
                        System.out.println("Is Square: " + isSquare);
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid option. Please try again.");
                shape = null;
                option = 0;
                continue;
            }

        }while(option != 4);

        sc.close();
    }
}
