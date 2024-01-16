package net.local.poc.employee.service.adapters.http.commands;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.application.ports.incoming.CreateEmployeeUseCase;
import net.local.poc.library.cqrs.Handler;

@Service
public class CreateEmployeeHandler implements Handler<CreateEmployeeCommand> {
    
    private final CreateEmployeeUseCase createEmployeeUseCase;

    public CreateEmployeeHandler(CreateEmployeeUseCase createEmployeeUseCase) {
        this.createEmployeeUseCase = createEmployeeUseCase;
    }

    @Override
    public void handle(CreateEmployeeCommand command) {
        createEmployeeUseCase.create(command.getEmployeeId(), 
                                     command.getEmployeeName(), 
                                     command.getDepartmentId(), 
                                     command.getOrganizationId());
    }
}
