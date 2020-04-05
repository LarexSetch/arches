package ru.airux.arches.repository;

import ru.airux.arches.domain.Property;

public interface PropertyRepository {
    void save(Property relation);

    Property findById(String id);

    void remove(Property relation);
}
