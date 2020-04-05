package ru.airux.arches.module.property;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.Property;
import ru.airux.arches.module.Command;
import ru.airux.arches.module.CommandException;
import ru.airux.arches.repository.PropertyRepository;

import java.util.UUID;

public class Create implements Command<Create.Request, Create.Response> {
    private PropertyRepository propertyRepository;

    public Create(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) throws CommandException {
        Property property = createProperty(request);
        propertyRepository.save(property);

        return new Response(property.getId());
    }

    private Property createProperty(Create.Request request) {
        return new Property(generateId(request), request.getElementId(), request.getName(), request.getType());
    }

    private String generateId(Create.Request request) {
        return UUID.randomUUID().toString();
    }


    public class Request {
        String elementId;
        String name;
        String type;

        public String getElementId() {
            return elementId;
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
