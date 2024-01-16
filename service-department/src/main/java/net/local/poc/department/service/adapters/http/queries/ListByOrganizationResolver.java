package net.local.poc.department.service.adapters.http.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.adapters.http.queries.dto.DepartmentResponse;
import net.local.poc.department.service.application.domain.Department;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentPort;
import net.local.poc.library.cqrs.Resolver;


@Service
public class ListByOrganizationResolver implements Resolver<ListByOrganizationQuery> {

    private final LoadDepartmentPort loadDepartmentPort;
    
    public ListByOrganizationResolver(LoadDepartmentPort loadDepartmentPort) {
        this.loadDepartmentPort = loadDepartmentPort;
    }

    @Override
    public void resolve(ListByOrganizationQuery query) {
        List<DepartmentResponse> result = loadDepartmentPort.loadByOrganization(query.getOrganizationId()).stream().map(this::mapToDTO).collect(Collectors.toList());
        query.setResult(result);
    }
    
    private DepartmentResponse mapToDTO(Department department) {
        return DepartmentResponse.builder()
                               .departmentId(department.getDepartmentId())
                               .departmentName(department.getDepartmentName())
                               .build();
    }
}
