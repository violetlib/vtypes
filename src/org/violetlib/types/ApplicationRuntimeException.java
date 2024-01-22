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
  An application exception for situations where only unchecked exceptions are permitted (for example, in an iterator).
*/

public final class ApplicationRuntimeException
  extends RuntimeException
{
    public static @NotNull ApplicationRuntimeException create(@NotNull String message)
    {
        return new ApplicationRuntimeException(ApplicationException.create(message));
    }

    public static @NotNull ApplicationRuntimeException create(@NotNull String message, @NotNull Throwable cause)
    {
        return new ApplicationRuntimeException(ApplicationException.create(message, cause));
    }

    public static @NotNull ApplicationRuntimeException create(@NotNull ApplicationException ex)
    {
        return new ApplicationRuntimeException(ex);
    }

    private final @NotNull ApplicationException original;

    private ApplicationRuntimeException(@NotNull ApplicationException ex)
    {
        super(ex);

        original = ex;
    }

    public @NotNull ApplicationException getApplicationException()
    {
        return original;
    }
}
