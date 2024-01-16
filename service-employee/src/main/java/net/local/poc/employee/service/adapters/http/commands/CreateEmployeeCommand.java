package net.local.poc.employee.service.adapters.http.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class CreateEmployeeCommand extends SelfValidating<CreateEmployeeCommand> implements Command {
    
    @NotBlank
    private final String employeeId;

    @NotBlank
    @Size(min = 1, max = 100)
    private final String employeeName;

    @NotBlank
    private final String departmentId;

    @NotBlank
    private final String organizationId;

    public CreateEmployeeCommand(String employeeId, String employeeName, String departmentId, String organizationId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.organizationId = organizationId;
        validateSelf(this);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getOrganizationId() {
        return organizationId;
    }
}
