package net.local.poc.organization.service.adapters.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.local.poc.organization.service.application.domain.Organization;
import net.local.poc.organization.service.application.ports.outgoing.DeleteOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.LoadOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.SaveOrganizationPort;

@Repository
public class OrganizationRepository implements LoadOrganizationPort, SaveOrganizationPort, DeleteOrganizationPort {

    private Map<String,Organization> inMemoryDB = new HashMap<>();

    @Override
    public Optional<Organization> load(String organizationId) {
        return Optional.ofNullable(inMemoryDB.get(organizationId));
    }

    @Override
    public void delete(String organizationId) {
        inMemoryDB.remove(organizationId);
    }

    @Override
    public void save(Organization organization) {
        inMemoryDB.putIfAbsent(organization.getOrganizationId(), organization);
    }    
}
