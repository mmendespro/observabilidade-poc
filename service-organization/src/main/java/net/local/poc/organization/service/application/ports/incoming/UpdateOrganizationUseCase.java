package net.local.poc.organization.service.application.ports.incoming;

public interface UpdateOrganizationUseCase {
    void update(String organizationId, String organizationName);
}
