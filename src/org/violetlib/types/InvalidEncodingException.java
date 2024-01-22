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
  An exception to report that encoded data is not valid.
*/

public final class InvalidEncodingException
  extends Exception
{
    /**
      Create an exception to report an invalid encoding using a generic message.
    */

    public static @NotNull InvalidEncodingException create()
    {
        return new InvalidEncodingException();
    }

    /**
      Create an exception to report an invalid encoding using a specific message.

      @param message A message that explains the problem with the encoding.
    */

    public static @NotNull InvalidEncodingException create(@NotNull String message)
    {
        return new InvalidEncodingException(message);
    }

    private InvalidEncodingException()
    {
        super("Encoded data format is invalid");
    }

    private InvalidEncodingException(@NotNull String message)
    {
        super(message);
    }
}
