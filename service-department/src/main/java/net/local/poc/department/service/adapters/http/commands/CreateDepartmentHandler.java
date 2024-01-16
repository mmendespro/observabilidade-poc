package net.local.poc.department.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.application.ports.incoming.CreateDepartmentUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class CreateDepartmentHandler implements Handler<CreateDepartmentCommand> {
    
    private final CreateDepartmentUseCase createDepartmentUseCase;

    public CreateDepartmentHandler(CreateDepartmentUseCase createDepartmentUseCase) {
        this.createDepartmentUseCase = createDepartmentUseCase;
    }

    @Override
    public void handle(CreateDepartmentCommand command) {
        createDepartmentUseCase.create(command.getDepartmentId(), command.getDepartmentName(), command.getOrganizationId());
    }
}
