package ru.airux.arches.repository;

import ru.airux.arches.domain.Property;

public interface PropertyRepository {
    void save(Property relation);

    void remove(Property relation);
}
