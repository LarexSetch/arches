package ru.airux.arches.domain;

import java.util.List;

public class Method {
    String id;
    String elementId;
    String name;
    AccessLevel accessLevel;
    List<MethodArgument> arguments;

    public Method(String id, String elementId, String name, AccessLevel accessLevel, List<MethodArgument> arguments) {
        this.id = id;
        this.elementId = elementId;
        this.name = name;
        this.accessLevel = accessLevel;
        this.arguments = arguments;
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

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<MethodArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<MethodArgument> arguments) {
        this.arguments = arguments;
    }
}
