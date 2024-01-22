/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.violetlib.annotations.Immutable;

/**
  An invalid data exception for situations where only unchecked exceptions are permitted (for example, in an iterator).
  <p>
  This exception is a generic exception for reporting invalid data to the user. It should not be used for failures, such
  as a database that contains unexpected invalid data.

  <p>
  This exception must have a message, because the message is typically displayed to the user as an explanation of the
  problem. The exception class name is not normally displayed.
*/

public final @Immutable class InvalidDataRuntimeException
  extends RuntimeException
{
    /**
      Create an invalid data exception with the specified message.

      @param msg The message.

      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull InvalidDataRuntimeException create(@NotNull String msg)
      throws IllegalArgumentException
    {
        return new InvalidDataRuntimeException(msg);
    }

    private InvalidDataRuntimeException(@NotNull String msg)
      throws IllegalArgumentException
    {
        super(fix(msg));
    }

    /**
      Create an invalid data exception with the specified message.

      @param msg The message.
      @param cause The cause.

      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull InvalidDataRuntimeException create(@NotNull String msg, @Nullable Throwable cause)
      throws IllegalArgumentException
    {
        return new InvalidDataRuntimeException(msg, cause);
    }

    private InvalidDataRuntimeException(@NotNull String msg, @Nullable Throwable cause)
      throws IllegalArgumentException
    {
        super(fix(msg), cause);
    }

    private static @NotNull String fix(@NotNull String msg)
      throws IllegalArgumentException
    {
        msg = msg.trim();
        if (msg.isEmpty()) {
            throw new IllegalArgumentException("Message must not be empty");
        }
        return msg;
    }
}
