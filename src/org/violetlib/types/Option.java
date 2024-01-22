/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.NotNull;
import org.violetlib.annotations.Immutable;

/**
  A unique named value suitable for a set of options.
*/

public final @Immutable class Option
{
    public static @NotNull Option named(@NotNull String name)
    {
        return new Option(name);
    }

    private final @NotNull String name;

    private Option(@NotNull String name)
    {
        this.name = name;
    }

    @Override
    public @NotNull String toString()
    {
        return name;
    }
}
