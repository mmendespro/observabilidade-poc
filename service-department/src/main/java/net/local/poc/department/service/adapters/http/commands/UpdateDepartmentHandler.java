package net.local.poc.department.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.application.ports.incoming.UpdateDepartmentUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class UpdateDepartmentHandler implements Handler<UpdateDepartmentCommand> {

    private final UpdateDepartmentUseCase updateDepartmentUseCase;

    public UpdateDepartmentHandler(UpdateDepartmentUseCase updateDepartmentUseCase) {
        this.updateDepartmentUseCase = updateDepartmentUseCase;
    }

    @Override
    public void handle(UpdateDepartmentCommand command) {
        updateDepartmentUseCase.update(command.getDepartmentId(), command.getDepartmentName(), command.getOrganizationId());
    }
}
