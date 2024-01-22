/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import java.util.Objects;

import org.jetbrains.annotations.*;
import org.violetlib.annotations.Immutable;

/**
  Options for scaling a shape to fit in a given display size or to magnify it by a fixed scale factor.
*/

public @Immutable class ScalingOption
{
    /**
      Do not scale the shape. Always display it at full resolution, regardless of whether it fits or not.
    */

    public static final @NotNull ScalingOption ACTUAL_SIZE = new ScalingOption("Actual Size");

    /**
      Scale the shape to fit within the available space, but preserve the aspect ratio.
    */

    public static final @NotNull ScalingOption SCALE_PRESERVE = new ScalingOption("Preserve Aspect Ratio");

    /**
      Scale the shape to fit within the available space, but preserve the aspect ratio and do not enlarge the shape.
    */

    public static final @NotNull ScalingOption SCALE_PRESERVE_REDUCE = new ScalingOption("Reduce Only");

    /**
      Scale the shape to fit exactly within the available space.
    */

    public static final @NotNull ScalingOption SCALE_FREE = new ScalingOption("Unconstrained");

    /**
      Create an option to scale by a fixed scale factor.
      @param scaleFactor The scale factor.
      @throws IllegalArgumentException if the scale factor is zero or negative.
    */

    public static @NotNull ScalingOption fixed(double scaleFactor)
      throws IllegalArgumentException
    {
        if (scaleFactor == 1) {
            return ACTUAL_SIZE;
        }
        return new FixedScaleOption(scaleFactor, "Fixed Scale Factor: " + scaleFactor);
    }

    private final @NotNull String name;

    protected ScalingOption(@NotNull String name)
    {
        this.name = name;
    }

    /**
      Return true if and only if this scaling option corresponds to a specified scale factor.
    */

    public boolean isSpecified()
    {
        return this == ACTUAL_SIZE;
    }

    /**
      If this scaling option corresponds to a specified scale factor, return the scale factor.
      @return the scale factor, or zero if this scaling option does not correspond to a specified scale factor.
    */

    public double getScaleFactor()
    {
        return this == ACTUAL_SIZE ? 1 : 0;
    }

    @Override
    public @NotNull String toString()
    {
        return name;
    }

    private static class FixedScaleOption
      extends ScalingOption
    {
        private final double scaleFactor;

        public FixedScaleOption(double scaleFactor, @NotNull String name)
          throws IllegalArgumentException
        {
            super(name);

            if (scaleFactor <= 0) {
                throw new IllegalArgumentException("Invalid scale factor");
            }

            this.scaleFactor = scaleFactor;
        }

        @Override
        public boolean isSpecified()
        {
            return true;
        }

        @Override
        public double getScaleFactor()
        {
            return scaleFactor;
        }

        @Override
        public boolean equals(@Nullable Object o)
        {
            if (this == o) return true;
            if (!(o instanceof FixedScaleOption)) return false;
            FixedScaleOption that = (FixedScaleOption) o;
            return Double.compare(that.scaleFactor, scaleFactor) == 0;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(scaleFactor);
        }
    }
}
