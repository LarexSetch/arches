package ru.airux.arches.module.method;

import org.checkerframework.checker.nullness.qual.NonNull;
import ru.airux.arches.domain.AccessLevel;
import ru.airux.arches.domain.Method;
import ru.airux.arches.domain.MethodArgument;
import ru.airux.arches.module.Command;
import ru.airux.arches.module.CommandException;
import ru.airux.arches.repository.MethodRepository;

import java.util.List;

public class Update implements Command<Update.Request, Update.Response> {
    private MethodRepository methodRepository;

    public Update(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @NonNull
    @Override
    public Response execute(Request request) throws CommandException {
        Method method = getMethod(request);
        method.setName(request.getName());
        method.setAccessLevel(request.getAccessLevel());
        method.setArguments(request.getArguments());

        methodRepository.save(method);

        return new Response(method.getId());
    }

    private Method getMethod(Request request) throws CommandException {
        Method method = methodRepository.findById(request.getId());
        if (null != method) {
            return method;
        }

        throw new CommandException();
    }

    public class Request {
        private String id;

        private String name;

        private AccessLevel accessLevel;

        private List<MethodArgument> arguments;

        public String getId() {
            return id;
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
