package net.local.poc.department.service.application.ports.outgoing;

import java.util.List;
import java.util.Optional;

import net.local.poc.department.service.application.domain.Department;

public interface LoadDepartmentPort {
    Optional<Department> load(String departmentId);
    List<Department> loadByOrganization(String organizationId);
}
