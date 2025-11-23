package com.codearp.patterns.factories.a_shapes.domains;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@EqualsAndHashCode
public abstract class Shape {

    public abstract void draw();
    public abstract double area();
    public abstract double perimeter();
}
