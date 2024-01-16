package net.local.poc.department.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.application.ports.incoming.DeleteDepartmentUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class DeleteDepartmentHandler implements Handler<DeleteDepartmentCommand> {
    
    private final DeleteDepartmentUseCase deleteDepartmentUseCase;

    public DeleteDepartmentHandler(DeleteDepartmentUseCase deleteDepartmentUseCase) {
        this.deleteDepartmentUseCase = deleteDepartmentUseCase;
    }

    @Override
    public void handle(DeleteDepartmentCommand command) {
        deleteDepartmentUseCase.delete(command.getDepartmentId());
    }
}
