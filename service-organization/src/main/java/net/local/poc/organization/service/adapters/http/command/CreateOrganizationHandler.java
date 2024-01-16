package net.local.poc.organization.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.library.cqrs.Handler;
import net.local.poc.organization.service.application.ports.incoming.CreateOrganizationUseCase;

@Component
public class CreateOrganizationHandler implements Handler<CreateOrganizationCommand> {

    private final CreateOrganizationUseCase createOrganizationUseCase;

    public CreateOrganizationHandler(CreateOrganizationUseCase createOrganizationUseCase) {
        this.createOrganizationUseCase = createOrganizationUseCase;
    }

    @Override
    public void handle(CreateOrganizationCommand command) {
        createOrganizationUseCase.create(command.getOrganizationId(), command.getOrganizationName());
    }
    
}
