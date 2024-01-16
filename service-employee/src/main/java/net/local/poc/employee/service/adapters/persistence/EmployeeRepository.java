package net.local.poc.employee.service.adapters.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.ports.outgoing.DeleteEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.SaveEmployeePort;

@Repository
public class EmployeeRepository implements LoadEmployeePort, SaveEmployeePort, DeleteEmployeePort {

    private Map<String,Employee> inMemoryDB = new HashMap<>();

    @Override
    public Optional<Employee> load(String employeeId) {
        return Optional.ofNullable(inMemoryDB.get(employeeId));
    }

    @Override
    public List<Employee> loadAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Employee> loadByDepartment(String departmentId) {
        return inMemoryDB.values().stream()
                                  .filter(emp -> departmentId.equals(emp.getDepartmentId()))
                                  .collect(Collectors.toList());
    }

    @Override
    public List<Employee> loadByOrganization(String organizationId) {
        return inMemoryDB.values().stream()
                                  .filter(emp -> organizationId.equals(emp.getOrganizationId()))
                                  .collect(Collectors.toList());
    }

    @Override
    public void save(Employee employee) {
        inMemoryDB.putIfAbsent(employee.getEmployeeId(), employee);
    }

    @Override
    public void delete(String employeeId) {
        inMemoryDB.remove(employeeId);
    }
}
