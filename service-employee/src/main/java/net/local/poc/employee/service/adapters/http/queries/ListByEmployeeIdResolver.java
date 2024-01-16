package net.local.poc.employee.service.adapters.http.queries;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.ports.incoming.ShowEmployeeUseCase;
import net.local.poc.library.cqrs.Resolver;

@Service
public class ListByEmployeeIdResolver implements Resolver<ListByEmployeeIdQuery> {

    private final ShowEmployeeUseCase showEmployeeUseCase;

    public ListByEmployeeIdResolver(ShowEmployeeUseCase showEmployeeUseCase) {
        this.showEmployeeUseCase = showEmployeeUseCase;
    }

    @Override
    public void resolve(ListByEmployeeIdQuery query) {
        query.setResult(mapToDTO(showEmployeeUseCase.show(query.getEmployeeId())));
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
