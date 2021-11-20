package ru.gx.events;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Metadata {
    @NotNull
    Object getKey();

    @Nullable
    Object getValue();
}
