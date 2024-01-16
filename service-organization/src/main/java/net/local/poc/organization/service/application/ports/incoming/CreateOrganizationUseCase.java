package net.local.poc.organization.service.application.ports.incoming;

public interface CreateOrganizationUseCase {
    void create(String organizationId, String organizationName);
}
