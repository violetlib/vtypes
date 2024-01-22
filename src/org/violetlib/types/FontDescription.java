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
  A platform-independent description of a font.
*/

public final @Immutable @Value class FontDescription
{
    /**
      Create a font description.

      @param family The name of the font family.
      @param weight The font weight, where 0 is regular. See the associated constants.
      @param size The font size, in points.
      @param isOblique True if the font posture is oblique.
      @throws IllegalArgumentException if {code weight} or {@code size} are invalid.
    */

    public static @NotNull FontDescription create(@NotNull String family, float weight, float size, boolean isOblique)
      throws IllegalArgumentException
    {
        return new FontDescription(family, weight, size, isOblique);
    }

    /**
      Create a font description for a font that is not oblique.

      @param family The name of the font family.
      @param weight The font weight, where 0 is regular. See the associated constants.
      @param size The font size, in points.
      @throws IllegalArgumentException if {code weight} or {@code size} are invalid.
    */

    public static @NotNull FontDescription create(@NotNull String family, float weight, float size)
      throws IllegalArgumentException
    {
        return new FontDescription(family, weight, size, false);
    }

    public static boolean isValidWeight(float weight)
    {
        return weight >= -1 && weight <= 1;
    }

    public static boolean isValidSize(float size)
    {
        return size >= 2 && size <= 1000;
    }

    // Convenient names for font weights
    public final static float ULTRA_LIGHT = -0.80f;
    public final static float THIN = -0.60f;
    public final static float LIGHT = -0.40f;
    public final static float REGULAR = 0;
    public final static float MEDIUM = 0.23f;
    public final static float SEMI_BOLD = 0.30f;
    public final static float BOLD = 0.40f;
    public final static float HEAVY = 0.56f;
    public final static float BLACK = 0.62f;

    private final @NotNull String family;
    private final float weight;
    private final float size;
    private final boolean isOblique;

    private FontDescription(@NotNull String family, float weight, float size, boolean isOblique)
      throws IllegalArgumentException
    {
        if (!isValidWeight(weight)) {
            throw new IllegalArgumentException("Invalid font weight: " + weight);
        }

        if (!isValidSize(size)) {
            throw new IllegalArgumentException("Invalid font size: " + size);
        }

        this.family = family;
        this.weight = weight;
        this.size = size;
        this.isOblique = isOblique;
    }

    public @NotNull String getFamily()
    {
        return family;
    }

    public float getWeight()
    {
        return weight;
    }

    public float getSize()
    {
        return size;
    }

    public boolean isOblique()
    {
        return isOblique;
    }

    public @NotNull FontDescription withWeight(float weight)
      throws IllegalArgumentException
    {
        return new FontDescription(family, weight, size, isOblique);
    }

    public @NotNull FontDescription withSize(float size)
      throws IllegalArgumentException
    {
        return new FontDescription(family, weight, size, isOblique);
    }

    public @NotNull FontDescription withOblique(boolean isOblique)
    {
        return new FontDescription(family, weight, size, isOblique);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof FontDescription)) return false;
        FontDescription that = (FontDescription) o;
        return Float.compare(weight, that.weight) == 0
          && Float.compare(size, that.size) == 0
          && isOblique == that.isOblique
          && Objects.equals(family, that.family);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(family, weight, size, isOblique);
    }

    @Override
    public @NotNull String toString()
    {
        return "Font{" +
                 "family=" + family +
                 ", weight=" + weight +
                 ", size=" + size +
                 '}';
    }
}
