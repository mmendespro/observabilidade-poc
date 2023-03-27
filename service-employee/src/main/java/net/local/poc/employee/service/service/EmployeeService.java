package net.local.poc.employee.service.service;

import java.util.List;
import java.util.Optional;

import net.local.poc.employee.service.domain.Employee;

public interface EmployeeService {

    List<Employee> loadAll();
    Optional<Employee> load(Long employeeId);
    List<Employee> loadByDepartment(Long departmentId);
    List<Employee> loadByOrganization(Long organizationId);
    
    void save(Employee employee);
    void delete(Long employeeId);
}
