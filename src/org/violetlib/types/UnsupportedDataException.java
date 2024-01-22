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
  An exception that may be thrown by a method when given unsupported data.
*/

public class UnsupportedDataException
  extends Exception
{
    public static @NotNull UnsupportedDataException create(@NotNull String message)
    {
        return new UnsupportedDataException(message);
    }

    public static @NotNull UnsupportedDataException create(@NotNull String message, @NotNull Throwable cause)
    {
        return new UnsupportedDataException(message, cause);
    }

    private UnsupportedDataException(@NotNull String message)
    {
        super(message);
    }

    private UnsupportedDataException(@NotNull String message, @NotNull Throwable cause)
    {
        super(message, cause);
    }
}
