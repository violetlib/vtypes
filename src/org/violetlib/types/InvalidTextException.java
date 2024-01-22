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
  An exception to report that user submitted text is not valid.
*/

public class InvalidTextException
  extends Exception
{
    /**
      Create an exception to report invalid text using a generic message.
    */

    public static @NotNull InvalidTextException create()
    {
        return new InvalidTextException();
    }

    /**
      Create an exception to report invalid text using a specific message.

      @param message A message that explains the problem with the text. The message should not
      include the actual text.
    */

    public static @NotNull InvalidTextException create(@NotNull String message)
    {
        return new InvalidTextException(message);
    }

    private InvalidTextException()
    {
        super("Invalid text");
    }

    private InvalidTextException(@NotNull String message)
    {
        super(message);
    }
}
