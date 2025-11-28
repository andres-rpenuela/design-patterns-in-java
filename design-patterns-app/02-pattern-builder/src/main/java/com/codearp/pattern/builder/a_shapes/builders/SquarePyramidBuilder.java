package com.codearp.pattern.builder.a_shapes.builders;

import com.codearp.pattern.builder.a_shapes.domains.spherical.SquarePyramid;

public class SquarePyramidBuilder {

    public static SquarePyramidSteps newBuilder() {
        return new Builder();
    }

    public interface SquarePyramidSteps {
        SquarePyramidSteps reset();
        SquarePyramidSteps withBase(double base);
        SquarePyramidSteps withHeight(double height);
        SquarePyramid build();
    }

    private static class Builder implements SquarePyramidSteps {

        private double base;
        private double height;

        protected Builder() {
            this.reset();
        }

        @Override
        public SquarePyramidSteps reset() {
            this.base = 0;
            this.height = 0;
            return this;
        }

        @Override
        public SquarePyramidSteps withBase(double base) {
            if (base <= 0) {
                throw new IllegalArgumentException("La base debe ser mayor que 0.");
            }
            this.base = base;
            return this;
        }

        @Override
        public SquarePyramidSteps withHeight(double height) {
            if (height <= 0) {
                throw new IllegalArgumentException("La altura debe ser mayor que 0.");
            }
            this.height = height;
            return this;
        }

        @Override
        public SquarePyramid build() {
            return new SquarePyramid(base, height);
        }
    }
}