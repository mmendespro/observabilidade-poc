package net.local.poc.department.service.adapters.http.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class UpdateDepartmentCommand extends SelfValidating<UpdateDepartmentCommand> implements Command {

    @NotBlank
    private final String departmentId;

    @NotBlank
    @Size(min = 1, max = 100)
    private final String departmentName;

    @NotBlank
    private final String organizationId;

    public UpdateDepartmentCommand(String departmentId, String departmentName, String organizationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.organizationId = organizationId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getOrganizationId() {
        return organizationId;
    }
    
}
