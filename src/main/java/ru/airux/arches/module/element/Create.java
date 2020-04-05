package ru.airux.arches.module.element;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.Element;
import ru.airux.arches.domain.ElementType;
import ru.airux.arches.module.Command;
import ru.airux.arches.repository.ElementRepository;

import java.util.UUID;

public class Create implements Command<Create.Request, Create.Response> {
    private ElementRepository elementRepository;

    public Create(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) {
        Element element = new Element(generateId(request), request.getName(), request.getType());
        elementRepository.save(element);

        return new Response(element.getName());
    }

    private String generateId(Request request) {
        return UUID.randomUUID().toString();
    }

    public class Request {
        private String name;
        private ElementType type;

        public Request(String name, ElementType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public ElementType getType() {
            return type;
        }
    }

    public class Response {
        private String id;

        public Response(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}
