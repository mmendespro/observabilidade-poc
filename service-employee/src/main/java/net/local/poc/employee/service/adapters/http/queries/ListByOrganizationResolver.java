package net.local.poc.employee.service.adapters.http.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.library.cqrs.Resolver;

@Service
public class ListByOrganizationResolver implements Resolver<ListByOrganizationQuery> {

    private final LoadEmployeePort loadEmployeePort;
    
    public ListByOrganizationResolver(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    @Override
    public void resolve(ListByOrganizationQuery query) {
        List<EmployeeResponse> result = loadEmployeePort.loadByOrganization(query.getOrganizationId()).stream().map(this::mapToDTO).collect(Collectors.toList());
        query.setResult(result);
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
