package ru.airux.arches.module;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface Command<I, O> {
    @NonNull
    O execute(I request) throws CommandException;
}
