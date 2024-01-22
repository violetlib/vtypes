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
  An exception indicating that a requested change is not permitted.
*/

public final class ChangeVetoException
  extends Exception
{
    public static @NotNull ChangeVetoException create()
    {
        return new ChangeVetoException();
    }

    public static @NotNull ChangeVetoException create(@NotNull String msg)
    {
        return new ChangeVetoException(msg);
    }

    private ChangeVetoException()
    {
        super();
    }

    private ChangeVetoException(@NotNull String msg)
    {
        super(msg);
    }
}
