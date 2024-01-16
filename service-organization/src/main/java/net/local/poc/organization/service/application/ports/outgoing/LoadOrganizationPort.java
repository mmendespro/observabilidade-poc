package net.local.poc.organization.service.application.ports.outgoing;

import java.util.Optional;

import net.local.poc.organization.service.application.domain.Organization;

public interface LoadOrganizationPort {
    Optional<Organization> load(String organizationId);
}
