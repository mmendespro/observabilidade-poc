package net.local.poc.organization.service.application.ports.outgoing;

import java.util.List;

import net.local.poc.organization.service.application.domain.dto.DepartmentDTO;

public interface LoadDepartmentPort {
    List<DepartmentDTO> load(String organizationId);
}
