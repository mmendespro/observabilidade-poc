package net.local.poc.organization.service.application.ports.outgoing;

import net.local.poc.organization.service.application.domain.Organization;

public interface SaveOrganizationPort {
    void save(Organization organization);
}
