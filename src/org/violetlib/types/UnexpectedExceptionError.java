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
  An error to be thrown when an exception is thrown that should not have happened.
*/

public final class UnexpectedExceptionError
  extends AssertionError
{
    public static @NotNull UnexpectedExceptionError create(@NotNull Exception ex)
    {
        return new UnexpectedExceptionError(ex);
    }

    private UnexpectedExceptionError(@NotNull Exception ex)
    {
        super("Unexpected exception", ex);
    }
}
