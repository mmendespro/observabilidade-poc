package net.local.poc.employee.service.adapters.http.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.library.cqrs.Resolver;

@Service
public class ListByDepartmentResolver implements Resolver<ListByDepartmentQuery> {

    private final LoadEmployeePort loadEmployeePort;
    
    public ListByDepartmentResolver(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    @Override
    public void resolve(ListByDepartmentQuery query) {
        List<EmployeeResponse> result = loadEmployeePort.loadByDepartment(query.getDepartmentId()).stream().map(this::mapToDTO).collect(Collectors.toList());
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
