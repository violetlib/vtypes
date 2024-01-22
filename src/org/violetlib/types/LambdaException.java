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
  A runtime exception used to pass an exception through a lambda.
*/

public final class LambdaException
  extends RuntimeException
{
    public static @NotNull LambdaException create(@NotNull Exception ex)
    {
        return new LambdaException(ex);
    }

    private LambdaException(@NotNull Exception ex)
    {
        super(ex);
    }

    public @NotNull Exception getException()
    {
        return (Exception) getCause();
    }
}
