/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import org.jetbrains.annotations.*;
import org.violetlib.annotations.Immutable;

/**
  A possibly null value that may be present or absent.
*/

public @Immutable class NullableOptional<T>
{
    public static <T> @NotNull NullableOptional<T> empty()
    {
        @SuppressWarnings("unchecked")
        NullableOptional<T> t = (NullableOptional<T>) EMPTY;
        return t;
    }

    public static <T> NullableOptional<T> of(@Nullable T value)
    {
        return new NullableOptional<>(true, value);
    }

    private static final NullableOptional<?> EMPTY = new NullableOptional<>(false, null);

    private final boolean isPresent;
    private final @Nullable T value;

    private NullableOptional(boolean isPresent, @Nullable T value)
    {
        this.isPresent = isPresent;
        this.value = value;
    }

    public @Nullable T get()
    {
        if (isPresent) {
            return value;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isPresent()
    {
        return isPresent;
    }

    public boolean isEmpty()
    {
        return !isPresent;
    }

    public void ifPresentOrElse(@NotNull Consumer<? super T> action, @NotNull Runnable emptyAction)
    {
        if (isPresent) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public @Nullable T orElse(@Nullable T other)
    {
        return isPresent ? value : other;
    }

    public T orElseThrow()
    {
        if (isPresent) {
            return value;
        }
        throw new NoSuchElementException("No value present");
    }

    @Override
    public boolean equals(@Nullable Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NullableOptional)) {
            return false;
        }

        NullableOptional<?> other = (NullableOptional<?>) obj;
        if (!isPresent) {
            return !other.isPresent();
        }

        return other.isPresent() && isEqualValue(value, other.get());
    }

    private static boolean isEqualValue(@Nullable Object o1, @Nullable Object o2)
    {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    @Override
    public int hashCode()
    {
        return isPresent ? Objects.hashCode(value) : 0;
    }
}
