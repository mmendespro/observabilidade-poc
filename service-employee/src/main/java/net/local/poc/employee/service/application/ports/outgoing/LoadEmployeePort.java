package net.local.poc.employee.service.application.ports.outgoing;

import java.util.List;
import java.util.Optional;

import net.local.poc.employee.service.application.domain.Employee;

public interface LoadEmployeePort {
    Optional<Employee> load(String employeeId);
    List<Employee> loadAll();
    List<Employee> loadByDepartment(String departmentId);
    List<Employee> loadByOrganization(String organizationId);
}
