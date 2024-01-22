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
  An operation failed exception for situations where only unchecked exceptions are permitted (for example, in an iterator).
*/

public class OperationFailedRuntimeException
  extends RuntimeException
{
    public static @NotNull OperationFailedRuntimeException create()
    {
        return new OperationFailedRuntimeException();
    }

    public static @NotNull OperationFailedRuntimeException create(@NotNull String message)
    {
        return new OperationFailedRuntimeException(message);
    }

    public static @NotNull OperationFailedRuntimeException create(@NotNull String message, @NotNull Throwable cause)
    {
        return new OperationFailedRuntimeException(message, cause);
    }

    public static @NotNull OperationFailedRuntimeException create(@NotNull Throwable cause)
    {
        return new OperationFailedRuntimeException(cause);
    }

    private OperationFailedRuntimeException()
    {
        super("The requested operation could not be performed");
    }

    private OperationFailedRuntimeException(String message)
    {
        super(message);
    }

    private OperationFailedRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    private OperationFailedRuntimeException(Throwable cause)
    {
        super("The requested operation could not be performed", cause);
    }
}
