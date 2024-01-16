package net.local.poc.organization.service.adapters.http.client;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.organization.service.application.domain.dto.DepartmentDTO;
import net.local.poc.organization.service.application.ports.outgoing.LoadDepartmentPort;

@Slf4j
@Component
public class LoadDepartments implements LoadDepartmentPort {

    private DepartmentClient client;

    public LoadDepartments(DepartmentClient client) {
        this.client = client;
    }

    @Override
    public List<DepartmentDTO> load(String organizationId) {
        log.info("Loading departments from organization {}", organizationId);
        return client.findByOrganization(organizationId).getBody();
    }
    
}
