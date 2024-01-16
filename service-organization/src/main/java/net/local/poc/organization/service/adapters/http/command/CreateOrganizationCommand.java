package net.local.poc.organization.service.adapters.http.command;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class CreateOrganizationCommand extends SelfValidating<CreateOrganizationCommand> implements Command {

    @NotBlank
    private final String organizationId;

    @NotBlank
    private final String organizationName;

    public CreateOrganizationCommand(String organizationId, String organizationName) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        validateSelf(this);
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }
}
