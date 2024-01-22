/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.*;

/**
  An assertion error for an unexpected undefined result.
*/

public class UndefinedValueError
  extends AssertionError
{
    public static @NotNull UndefinedValueError create(@NotNull String message)
    {
        return new UndefinedValueError(message);
    }

    private UndefinedValueError(@NotNull String message)
    {
        super(message);
    }
}
