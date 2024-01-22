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
  An unchecked exception that corresponds to {@link InterruptedException}.
*/

public final class InterruptedRuntimeException
  extends RuntimeException
{
    public static @NotNull InterruptedRuntimeException create(@NotNull InterruptedException ex)
    {
        return new InterruptedRuntimeException(ex);
    }

    private final @NotNull InterruptedException original;

    private InterruptedRuntimeException(@NotNull InterruptedException ex)
    {
        super(ex);

        this.original = ex;
    }

    public @NotNull InterruptedException getInterruptedException()
    {
        return original;
    }
}
