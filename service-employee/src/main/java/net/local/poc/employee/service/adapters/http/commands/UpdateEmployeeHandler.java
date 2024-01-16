package net.local.poc.employee.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.application.ports.incoming.UpdateEmployeeUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class UpdateEmployeeHandler implements Handler<UpdateEmployeeCommand> {
    
    private final UpdateEmployeeUseCase updateEmployeeUseCase;

    public UpdateEmployeeHandler(UpdateEmployeeUseCase updateEmployeeUseCase) {
        this.updateEmployeeUseCase = updateEmployeeUseCase;
    }

    @Override
    public void handle(UpdateEmployeeCommand command) {
        updateEmployeeUseCase.update(command.getEmployeeId(), 
                                     command.getEmployeeName(), 
                                     command.getDepartmentId(), 
                                     command.getOrganizationId());
    }
}
