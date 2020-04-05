package ru.airux.arches.module.property;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.Property;
import ru.airux.arches.module.Command;
import ru.airux.arches.module.CommandException;
import ru.airux.arches.repository.PropertyRepository;

public class Update implements Command<Update.Request, Update.Response> {
    private PropertyRepository propertyRepository;

    public Update(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) throws CommandException {
        Property property = getProperty(request);
        property.setName(request.getName());
        property.setType(request.getType());

        return new Response(request.getId());
    }

    private Property getProperty(Request request) throws CommandException {
        Property property = propertyRepository.findById(request.getId());
        if (null != property) {
            return property;
        }

        throw new CommandException();
    }

    public class Request {
        private String id;

        private String name;

        private String type;

        public Request(String id, String name, String type) {
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

        public String getType() {
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
