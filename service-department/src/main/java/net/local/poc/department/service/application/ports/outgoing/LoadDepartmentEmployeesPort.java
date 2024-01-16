package net.local.poc.department.service.application.ports.outgoing;

import java.util.List;

import net.local.poc.department.service.application.domain.dto.EmployeeDTO;

public interface LoadDepartmentEmployeesPort {
    List<EmployeeDTO> load(String departmentId);
}
