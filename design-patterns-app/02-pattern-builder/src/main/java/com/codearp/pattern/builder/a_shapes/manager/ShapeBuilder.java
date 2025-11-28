package com.codearp.pattern.builder.a_shapes.manager;

import com.codearp.pattern.builder.a_shapes.builders.SquarePyramidBuilder;
import com.codearp.pattern.builder.a_shapes.domains.Shape;

public class ShapeBuilder {

    public static Shape createSquarePyramid(double base, double height) {
        return SquarePyramidBuilder.newBuilder().withBase(base).withHeight(height).build();
    }
}
