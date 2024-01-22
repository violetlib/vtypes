/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import org.jetbrains.annotations.*;
import org.violetlib.annotations.Immutable;

/**
  A generic exception for data read/write failures. This exception class should not be used for anticipated failures,
  such as a query that returns no results.
*/

public @Immutable class DataException
  extends RuntimeException
{
    /**
      Create a data exception with the specified message.

      @param msg The message.
      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull DataException create(@NotNull String msg)
    {
        return new DataException(msg);
    }

    protected DataException(@NotNull String msg)
      throws IllegalArgumentException
    {
        super(fix(msg));
    }

    /**
      Create a data exception with the specified message and cause.

      @param msg The message.
      @param cause The cause.
      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull DataException create(@NotNull String msg, @NotNull Throwable cause)
    {
        return new DataException(msg, cause);
    }

    protected DataException(@NotNull String msg, @Nullable Throwable cause)
      throws IllegalArgumentException
    {
        super(fix(msg), cause);
    }

    /**
      Create a data exception with the specified cause. A message is created using the cause.

      @param cause The cause.
    */

    public static @NotNull DataException create(@NotNull Throwable cause)
    {
        return new DataException(cause);
    }

    protected DataException(@NotNull Throwable cause)
    {
        super(createMessage(cause), cause);
    }

    public @NotNull ApplicationException asApplicationException()
    {
        return ApplicationException.create("A database error occurred", this);
    }

    private static @NotNull String createMessage(@NotNull Throwable cause)
    {
        String message = cause.getMessage().trim();
        if(message.isEmpty()) {
            message = "A database error occurred";
        }
        return message;
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
