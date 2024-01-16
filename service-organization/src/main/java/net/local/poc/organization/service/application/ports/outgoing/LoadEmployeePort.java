package net.local.poc.organization.service.application.ports.outgoing;

import java.util.List;

import net.local.poc.organization.service.application.domain.dto.EmployeeDTO;

public interface LoadEmployeePort {
    List<EmployeeDTO> load(String organizationId);
}
