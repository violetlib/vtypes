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
  An exception with an explanation that can be shown to a user.
  The explanation should be meaningful without the exception class name being visible.
  Any code that handles this exception should probably also handle {@link ApplicationRuntimeException}.
*/

public class ApplicationException
  extends Exception
{
    /**
      Create an application exception with the specified message.

      @param msg The message.

      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull ApplicationException create(@NotNull String message)
    {
        return new ApplicationException(message);
    }

    /**
      Create an application exception with the specified message and cause.

      @param msg The message.
      @param cause The cause.

      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull ApplicationException create(@NotNull String message, @NotNull Throwable cause)
    {
        return new ApplicationException(message, cause);
    }

    /**
      Create an application exception with the specified message and optional detail.

      @param msg The message.
      @param detail An optional detailed description.

      @throws IllegalArgumentException if <code>msg</code> is empty.
    */

    public static @NotNull ApplicationException create(@NotNull String message, @Nullable String detail)
    {
        return new ApplicationException(message, detail);
    }

    private final @Nullable String detail;

    protected ApplicationException(@NotNull String message)
    {
        super(fix(message));

        this.detail = null;
    }

    protected ApplicationException(@NotNull String message, @NotNull Throwable cause)
    {
        super(fix(message), cause);

        this.detail = null;
    }

    protected ApplicationException(@NotNull String message, @Nullable String detail)
    {
        super(fix(message));

        this.detail = detail;
    }

    public @Nullable String getDetail()
    {
        return detail;
    }

    /**
      This method returns the exception message (only). This choice is for the convenience of reporting the exception.
    */

    @Override
    public @NotNull String toString()
    {
        return getMessage();
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
