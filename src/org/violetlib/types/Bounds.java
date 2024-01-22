/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.*;
import org.violetlib.annotations.Immutable;
import org.violetlib.annotations.Value;

import java.util.Objects;

/**
  A platform-independent description of a rectangular area.
*/

public final @Immutable @Value class Bounds
{
    public static @NotNull Bounds create(int x, int y, int width, int height)
    {
        return new Bounds(x, y, width, height);
    }

    public final int x;
    public final int y;
    public final int width;
    public final int height;

    private Bounds(int x, int y, int width, int height)
    {
        if (width < 0) {
            throw new IllegalArgumentException("Invalid width: " + width);
        }

        if (height < 0) {
            throw new IllegalArgumentException("Invalid height: " + height);
        }

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(int px, int py)
    {
        return px >= x && px <= x + width && py >= y && py <= y + height;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Bounds)) return false;
        Bounds bounds = (Bounds) o;
        return x == bounds.x && y == bounds.y && width == bounds.width && height == bounds.height;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, width, height);
    }

    public @NotNull Bounds enlarge(int delta)
      throws IllegalArgumentException
    {
        if (delta < 0) {
            throw new IllegalArgumentException("Bounds enlargement must not be negative");
        }
        if (delta == 0) {
            return this;
        }
        return new Bounds(x - delta, y - delta, width + 2 * delta, height + 2 * delta);
    }

    public @NotNull Bounds offset(int xOffset, int yOffset)
    {
        if (xOffset == 0 && yOffset == 0) {
            return this;
        }
        return new Bounds(x + xOffset, y + yOffset, width, height);
    }

    @Override
    public @NotNull String toString()
    {
        return x + " " + y + " " + width + "x" + height;
    }
}
