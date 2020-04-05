package ru.airux.arches.module.method;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.AccessLevel;
import ru.airux.arches.domain.Method;
import ru.airux.arches.domain.MethodArgument;
import ru.airux.arches.module.Command;
import ru.airux.arches.module.CommandException;
import ru.airux.arches.repository.MethodRepository;

import java.util.List;
import java.util.UUID;

public class Create implements Command<Create.Request, Create.Response> {
    private MethodRepository methodRepository;

    public Create(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) throws CommandException {
        Method method = new Method(
            generateId(request),
            request.getElementId(),
            request.getName(),
            request.getAccessLevel(),
            request.getArguments()
        );
        methodRepository.save(method);

        return new Response(method.getId());
    }

    private String generateId(Request request) {
        return UUID.randomUUID().toString();
    }

    public class Request {
        private String elementId;

        private String name;

        private AccessLevel accessLevel;

        private List<MethodArgument> arguments;

        public String getElementId() {
            return elementId;
        }

        public String getName() {
            return name;
        }

        public AccessLevel getAccessLevel() {
            return accessLevel;
        }

        public List<MethodArgument> getArguments() {
            return arguments;
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
