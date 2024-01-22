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
  A platform-independent description of insets.
*/

public final @Immutable @Value class InsetDescription
{
    private static final @NotNull InsetDescription ZERO = new InsetDescription(0);

    public static @NotNull InsetDescription zero()
    {
        return ZERO;
    }

    public static @NotNull InsetDescription create(int top, int left, int bottom, int right)
    {
        if (top < 0 || left < 0 || bottom < 0 || right < 0) {
            throw new IllegalArgumentException("Invalid insets");
        }

        if (top == 0 && left == 0 && bottom == 0 && right == 0) {
            return ZERO;
        }

        return new InsetDescription(top, left, bottom, right);
    }

    public static @NotNull InsetDescription create(int topBottom, int side)
    {
        return create(topBottom, side, topBottom, side);
    }

    public static @NotNull InsetDescription create(int n)
    {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid insets");
        }

        if (n == 0) {
            return ZERO;
        }

        return new InsetDescription(n);
    }

    private final int top;
    private final int left;
    private final int bottom;
    private final int right;

    private InsetDescription(int top, int left, int bottom, int right)
    {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    private InsetDescription(int n)
    {
        this.top = n;
        this.left = n;
        this.bottom = n;
        this.right = n;
    }

    public boolean isZero()
    {
        return this == ZERO;
    }

    public int getTop()
    {
        return top;
    }

    public int getLeft()
    {
        return left;
    }

    public int getBottom()
    {
        return bottom;
    }

    public int getRight()
    {
        return right;
    }

    public int getWidth()
    {
        return left + right;
    }

    public int getHeight()
    {
        return top + bottom;
    }

    public @NotNull InsetDescription add(@NotNull InsetDescription d)
    {
        if (d.isZero()) {
            return this;
        }
        return new InsetDescription(top + d.getTop(), left + d.getLeft(), bottom + d.getBottom(), right + d.getRight());
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o) return true;
        if (!(o instanceof InsetDescription)) return false;
        InsetDescription that = (InsetDescription) o;
        return top == that.top && left == that.left && bottom == that.bottom && right == that.right;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(top, left, bottom, right);
    }

    @Override
    public @NotNull String toString()
    {
        return "InsetDescription{" +
                 "top=" + top +
                 ", left=" + left +
                 ", bottom=" + bottom +
                 ", right=" + right +
                 '}';
    }
}
