package ru.airux.arches.domain;

public class Property {
    String id;
    String elementId;
    String name;
    String type;

    public Property(String id, String elementId, String name, String type) {
        this.id = id;
        this.elementId = elementId;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
