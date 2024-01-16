package net.local.poc.employee.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.application.ports.incoming.DeleteEmployeeUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class DeleteEmployeeHandler implements Handler<DeleteEmployeeCommand> {

    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    public DeleteEmployeeHandler(DeleteEmployeeUseCase deleteEmployeeUseCase) {
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
    }

    @Override
    public void handle(DeleteEmployeeCommand command) {
        deleteEmployeeUseCase.delete(command.getEmployeeId());
    }    
}
