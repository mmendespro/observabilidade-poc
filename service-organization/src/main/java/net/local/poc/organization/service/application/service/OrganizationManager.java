package net.local.poc.organization.service.application.service;

import net.local.poc.organization.service.application.domain.Organization;
import net.local.poc.organization.service.application.exceptions.OrganizationAlreadyExstisException;
import net.local.poc.organization.service.application.exceptions.OrganizationNotFoundException;
import net.local.poc.organization.service.application.ports.incoming.CreateOrganizationUseCase;
import net.local.poc.organization.service.application.ports.incoming.DeleteOrganizationUseCase;
import net.local.poc.organization.service.application.ports.incoming.UpdateOrganizationUseCase;
import net.local.poc.organization.service.application.ports.outgoing.DeleteOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.LoadOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.SaveOrganizationPort;

public class OrganizationManager implements CreateOrganizationUseCase, UpdateOrganizationUseCase, DeleteOrganizationUseCase {
    
    private final LoadOrganizationPort loadOrganizationPort;
    private final SaveOrganizationPort saveOrganizationPort;
    private final DeleteOrganizationPort deleteOrganizationPort;

    public OrganizationManager(LoadOrganizationPort loadOrganizationPort, SaveOrganizationPort saveOrganizationPort, DeleteOrganizationPort deleteOrganizationPort) {
        this.loadOrganizationPort = loadOrganizationPort;
        this.saveOrganizationPort = saveOrganizationPort;
        this.deleteOrganizationPort = deleteOrganizationPort;
    }

    @Override
    public void create(String organizationId, String organizationName) {
        loadOrganizationPort.load(organizationId).ifPresent(org -> { throw new OrganizationAlreadyExstisException(); });

        var organization = Organization.builder().organizationId(organizationId).organizationName(organizationName).build();

        saveOrganizationPort.save(organization);
    }

    @Override
    public void update(String organizationId, String organizationName) {
        loadOrganizationPort.load(organizationId).orElseThrow(OrganizationNotFoundException::new);

        var organization = Organization.builder().organizationId(organizationId).organizationName(organizationName).build();

        saveOrganizationPort.save(organization);
    }

    @Override
    public void delete(String organizationId) {
        loadOrganizationPort.load(organizationId).orElseThrow(OrganizationNotFoundException::new);
        deleteOrganizationPort.delete(organizationId);
    }
}
