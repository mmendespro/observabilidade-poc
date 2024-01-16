package net.local.poc.department.service.adapters.http.queries;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.adapters.http.queries.dto.DepartmentDetailResponse;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentEmployeesPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentPort;
import net.local.poc.library.cqrs.Resolver;

@Service
public class DetailDepartmentResolver implements Resolver<DetailDepartmentQuery> {
    
    private final LoadDepartmentPort loadDepartmentPort;
    private final LoadDepartmentEmployeesPort loadDepartmentEmployeesPort;

    public DetailDepartmentResolver(LoadDepartmentPort loadDepartmentPort, LoadDepartmentEmployeesPort loadDepartmentEmployeesPort) {
        this.loadDepartmentPort = loadDepartmentPort;
        this.loadDepartmentEmployeesPort = loadDepartmentEmployeesPort;
    }

    @Override
    public void resolve(DetailDepartmentQuery query) {
        var department = loadDepartmentPort.load(query.getDepartmentId()).get();
        var employees = loadDepartmentEmployeesPort.load(query.getDepartmentId());
        var result = DepartmentDetailResponse.builder()
                                             .departmentId(department.getDepartmentId())
                                             .departmentName(department.getDepartmentName())
                                             .employees(employees)
                                             .build();
        query.setResult(result);
    }
}
