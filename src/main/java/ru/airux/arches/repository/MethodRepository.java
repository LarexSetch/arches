package ru.airux.arches.repository;

import ru.airux.arches.domain.Method;

public interface MethodRepository {
    void save(Method method);

    Method findById(String id);
}
