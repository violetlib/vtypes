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
  A platform-independent description of a point in a two dimensional space.
*/

public final @Immutable @Value class Position
{
    public static @NotNull Position create(int x, int y)
    {
        return new Position(x, y);
    }

    public final int x;
    public final int y;

    private Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position size = (Position) o;
        return x == size.x && y == size.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public @NotNull String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
