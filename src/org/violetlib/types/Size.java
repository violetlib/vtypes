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
import org.violetlib.annotations.Value;

/**
  A platform-independent description of the size of a rectangular area.
*/

public final @Immutable @Value class Size
{
    /**
      Create a description of the size of a rectangular area.
      @param width The width.
      @param height The height.
      @return the size description.
      @throws IllegalArgumentException if {@code width} or {@code height} is negative.
    */

    public static @NotNull Size create(int width, int height)
      throws IllegalArgumentException
    {
        return new Size(width, height);
    }

    public static final @NotNull Size ZERO = new Size(0, 0);

    public final int width;
    public final int height;

    private Size(int width, int height)
      throws IllegalArgumentException
    {
        if (width < 0) {
            throw new IllegalArgumentException("Invalid width: " + width);
        }

        if (height < 0) {
            throw new IllegalArgumentException("Invalid height: " + height);
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Size)) return false;
        Size size = (Size) o;
        return width == size.width && height == size.height;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(width, height);
    }

    @Override
    public @NotNull String toString()
    {
        return width + "x" + height;
    }
}
