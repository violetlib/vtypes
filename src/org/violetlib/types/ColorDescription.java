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
  A platform-independent description of a color.
*/

public final @Immutable @Value class ColorDescription
{
    public final static @NotNull ColorDescription CLEAR = ColorDescription.color(0, 0, 0, 0);
    public final static @NotNull ColorDescription BLACK = ColorDescription.color(0, 0, 0, 1);
    public final static @NotNull ColorDescription WHITE = ColorDescription.color(1, 1, 1, 1);
    public final static @NotNull ColorDescription RED = ColorDescription.color(1, 0, 0, 1);
    public final static @NotNull ColorDescription GREEN = ColorDescription.color(0, 1, 0, 1);
    public final static @NotNull ColorDescription BLUE = ColorDescription.color(0, 0, 1, 1);
    public final static @NotNull ColorDescription GRAY = ColorDescription.color(0.5, 0.5, 0.5, 1);
    public final static @NotNull ColorDescription YELLOW = ColorDescription.color(1, 1, 0, 1);

    public static @NotNull ColorDescription gray(int intensity)
    {
        float v = intensity / 255f;
        return new ColorDescription(v, v, v, 1f);
    }

    public static @NotNull ColorDescription create(int red, int green, int blue)
    {
        return new ColorDescription(red / 255f, green / 255f, blue / 255f, 1f);
    }

    public static @NotNull ColorDescription create(int red, int green, int blue, int alpha)
    {
        return new ColorDescription(red / 255f, green / 255f, blue / 255f, alpha / 255f);
    }

    public static @NotNull ColorDescription color(float intensity)
    {
        return new ColorDescription(intensity, intensity, intensity, 1f);
    }

    public static @NotNull ColorDescription color(double intensity)
    {
        float f = (float) intensity;
        return new ColorDescription(f, f, f, 1f);
    }

    public static @NotNull ColorDescription color(float red, float green, float blue)
    {
        return new ColorDescription(red, green, blue, 1f);
    }

    public static @NotNull ColorDescription color(double red, double green, double blue)
    {
        return new ColorDescription((float) red, (float) green, (float) blue, 1f);
    }

    public static @NotNull ColorDescription color(float red, float green, float blue, float alpha)
    {
        return new ColorDescription(red, green, blue, alpha);
    }

    public static @NotNull ColorDescription color(double red, double green, double blue, double alpha)
    {
        return new ColorDescription((float) red, (float) green, (float) blue, (float) alpha);
    }

    private final float red;
    private final float green;
    private final float blue;
    private final float alpha;

    private ColorDescription(float red, float green, float blue, float alpha)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public float getRed()
    {
        return red;
    }

    public float getGreen()
    {
        return green;
    }

    public float getBlue()
    {
        return blue;
    }

    public float getAlpha()
    {
        return alpha;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof ColorDescription)) return false;
        ColorDescription that = (ColorDescription) o;
        return Float.compare(red, that.red) == 0
          && Float.compare(green, that.green) == 0
          && Float.compare(blue, that.blue) == 0
          && Float.compare(alpha, that.alpha) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(red, green, blue, alpha);
    }

    @Override
    public @NotNull String toString()
    {
        return "ColorDescription{" +
                 "red=" + red +
                 ", green=" + green +
                 ", blue=" + blue +
                 ", alpha=" + alpha +
                 '}';
    }
}
