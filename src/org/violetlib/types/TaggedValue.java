/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import java.util.Optional;
import java.util.concurrent.CompletionException;

import org.jetbrains.annotations.*;
import org.violetlib.annotations.Immutable;

/**
  A tagged value represents the result of a computation, which either produces a (possibly null) value or throws.
*/

public final @Immutable class TaggedValue<T>
{
    private final boolean isValue;
    private final @Nullable T value;
    private final @Nullable Throwable error;

    public static <T> @NotNull TaggedValue<T> of(@Nullable T value)
    {
        return new TaggedValue<>(true, value, null);
    }

    public static <T> @NotNull TaggedValue<T> error(@NotNull Throwable error)
    {
        return new TaggedValue<>(false, null, error);
    }

    private TaggedValue(boolean isValue, @Nullable T value, @Nullable Throwable error)
    {
        this.isValue = isValue;
        this.value = value;
        this.error = error;
    }

    /**
      Return true if and only if a value is present.
    */

    public boolean isPresent()
    {
        return isValue;
    }

    /**
      Return true if and only if a value is not present.
    */

    public boolean isError()
    {
        return !isValue;
    }

    /**
      Return the value, if present and not null.
      @return the value, or empty if the value is null or no value is available.
    */

    public @NotNull Optional<T> get()
    {
        return isValue ? Optional.ofNullable(value) : Optional.empty();
    }

    /**
      Return the value, if present.
      @return the value, or null if no value is available.
    */

    public @Nullable T getValue()
    {
        return isValue ? value : null;
    }

    /**
      Return the error, if no value is present.
      @return the error, or null if no value is present.
    */

    public @Nullable Throwable getError()
    {
        return error;
    }

    /**
      If the value is present, return the value.
      Otherwise throw the associated error, either directly or wrapped in a {@link CompletionException}.
      @param message The message to associated with the wrapped runtime exception.
    */

    public @Nullable T throwIfError(@NotNull String message)
    {
        if (error != null) {
            if (error instanceof RuntimeException) {
                throw (RuntimeException) error;
            } else {
                throw new CompletionException(message, error);
            }
        }
        return value;
    }
}
