/*
 * Copyright (c) 2023 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */

package org.violetlib.types;

import java.io.File;
import java.io.FileFilter;

import org.jetbrains.annotations.*;

/**
  A file filter with a description for use in a file dialog menu.
  Equivalent to the JFileChooser file filter.
*/

public interface UIFileFilter
  extends FileFilter
{
    @Override
    boolean accept(@NotNull File pathname);

    @NotNull String getDescription();
}
