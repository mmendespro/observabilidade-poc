package net.local.poc.employee.service.adapters.http.commands;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class DeleteEmployeeCommand extends SelfValidating<DeleteEmployeeCommand> implements Command {
    
    @NotBlank
    private final String employeeId;

    public DeleteEmployeeCommand(String employeeId) {
        this.employeeId = employeeId;
        validateSelf(this);
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
