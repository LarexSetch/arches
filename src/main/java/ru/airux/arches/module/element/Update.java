package ru.airux.arches.module.element;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.Element;
import ru.airux.arches.domain.ElementType;
import ru.airux.arches.module.Command;
import ru.airux.arches.module.CommandException;
import ru.airux.arches.repository.ElementRepository;

public class Update implements Command<Update.Request, Update.Response> {
    private ElementRepository elementRepository;

    public Update(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) throws CommandException {
        Element element = getElement(request);
        element.setName(request.getName());
        element.setType(request.getType());

        return new Response(request.getId());
    }

    @NonNull
    private Element getElement(@NonNull Request request) throws CommandException {
        Element element = elementRepository.findById(request.getId());
        if (null != element) {
            return element;
        }

        throw new CommandException();
    }

    public class Request {
        String id;
        String name;
        ElementType type;

        public Request(String id, String name, ElementType type) {
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
