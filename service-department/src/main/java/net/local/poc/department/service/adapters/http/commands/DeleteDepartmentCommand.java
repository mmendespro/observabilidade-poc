package net.local.poc.department.service.adapters.http.commands;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class DeleteDepartmentCommand extends SelfValidating<DeleteDepartmentCommand> implements Command{
    
    @NotBlank
    private final String departmentId;

    public DeleteDepartmentCommand(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
