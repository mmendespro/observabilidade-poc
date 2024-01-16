package net.local.poc.department.service.application.ports.outgoing;

import net.local.poc.department.service.application.domain.Department;

public interface SaveDepartmentPort {
    void save(Department department);
}
