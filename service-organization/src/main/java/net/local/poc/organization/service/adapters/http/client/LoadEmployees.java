package net.local.poc.organization.service.adapters.http.client;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.organization.service.application.domain.dto.EmployeeDTO;
import net.local.poc.organization.service.application.ports.outgoing.LoadEmployeePort;

@Slf4j
@Component
public class LoadEmployees implements LoadEmployeePort {
    
    private EmployeeClient client;

    public LoadEmployees(EmployeeClient client) {
        this.client = client;
    }

    @Override
    public List<EmployeeDTO> load(String organizationId) {
        log.info("Loading employees from organization {}", organizationId);
        return client.findByDepartment(organizationId).getBody();
    }
}
