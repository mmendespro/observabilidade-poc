package net.local.poc.organization.service.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.organization.service.application.ports.outgoing.DeleteOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.LoadOrganizationPort;
import net.local.poc.organization.service.application.ports.outgoing.SaveOrganizationPort;
import net.local.poc.organization.service.application.service.OrganizationManager;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public OrganizationManager manager(LoadOrganizationPort loadOrganizationPort, SaveOrganizationPort saveOrganizationPort, DeleteOrganizationPort deleteOrganizationPort) {
        return new OrganizationManager(loadOrganizationPort, saveOrganizationPort, deleteOrganizationPort);
    }
}
