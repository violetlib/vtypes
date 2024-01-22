/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import java.io.IOException;

import org.jetbrains.annotations.*;

/**
  An IO exception for situations where only a runtime exception is permitted (for example, in an iterator).
*/

public class IORuntimeException
  extends RuntimeException
{
    public static @NotNull IORuntimeException create(@NotNull IOException ex)
    {
        return new IORuntimeException(ex);
    }

    public static @NotNull IORuntimeException create(@NotNull String message)
    {
        return new IORuntimeException(new IOException(message));
    }

    /**
      This method is used in catch clauses that handle both IOException and IORuntimeException.
    */

    public static @NotNull IOException toIOException(@NotNull Exception ex)
    {
        if (ex instanceof IOException) {
            return (IOException) ex;
        }
        if (ex instanceof IORuntimeException) {
            return ((IORuntimeException) ex).getIOException();
        }
        throw new IllegalArgumentException("Not an IOException");
    }

    private final @NotNull IOException original;

    private IORuntimeException(@NotNull IOException x)
    {
        super(x);

        original = x;
    }

    public @NotNull IOException getIOException()
    {
        return original;
    }
}
