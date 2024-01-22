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
  A generic exception indicating that an operation has failed.
  Any code that handles this exception should probably also handle {@link OperationFailedRuntimeException}.
*/

public final class OperationFailedException
  extends Exception
{
    public static @NotNull OperationFailedException create()
    {
        return new OperationFailedException();
    }

    public static @NotNull OperationFailedException create(@NotNull String message)
    {
        return new OperationFailedException(message);
    }

    public static @NotNull OperationFailedException create(@NotNull String message, @NotNull Throwable cause)
    {
        return new OperationFailedException(message, cause);
    }

    public static @NotNull OperationFailedException create(@NotNull Throwable cause)
    {
        return new OperationFailedException(cause);
    }

    private OperationFailedException()
    {
        super("The requested operation could not be performed");
    }

    private OperationFailedException(@NotNull String message)
    {
        super(message);
    }

    private OperationFailedException(@NotNull String message, @NotNull Throwable cause)
    {
        super(message, cause);
    }

    private OperationFailedException(@NotNull Throwable cause)
    {
        super("The requested operation could not be performed", cause);
    }
}
