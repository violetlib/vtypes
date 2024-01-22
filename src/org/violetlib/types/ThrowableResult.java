/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.NotNull;

/**
  A result that can be thrown.
*/

public final class ThrowableResult
  extends RuntimeException
{
    public static <T> @NotNull ThrowableResult of(@NotNull T value)
    {
        return new ThrowableResult(value);
    }

    public final @NotNull Object value;

    private ThrowableResult(@NotNull Object value)
    {
        this.value = value;
    }
}
