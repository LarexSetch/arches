package ru.airux.arches.repository;

import ru.airux.arches.domain.Element;

public interface ElementRepository {
    void save(Element element);

    Element findById(String id);

    void remove(Element element);
}
