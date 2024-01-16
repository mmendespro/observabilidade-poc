package net.local.poc.employee.service.adapters.http.queries;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.library.cqrs.Resolver;

@Service
public class ListAllEmployeeResolver implements Resolver<ListAllEmployeeQuery> {
    
    private final LoadEmployeePort loadEmployeePort;

    public ListAllEmployeeResolver(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    @Override
    public void resolve(ListAllEmployeeQuery query) {
        query.setResult(loadEmployeePort.loadAll().stream().map(this::mapToDTO).collect(Collectors.toList()));
    }

    private EmployeeResponse mapToDTO(Employee employee) {
        return EmployeeResponse.builder()
                               .employeeId(employee.getEmployeeId())
                               .employeeName(employee.getEmployeeName())
                               .departmentId(employee.getDepartmentId())
                               .organizationId(employee.getOrganizationId())
                               .build();
    }
}
