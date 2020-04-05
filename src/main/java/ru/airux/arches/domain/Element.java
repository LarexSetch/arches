package ru.airux.arches.domain;

import java.util.List;

public class Element {
    private String id;
    private String name;
    private ElementType type;

    public Element(String id, String name, ElementType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }
}
