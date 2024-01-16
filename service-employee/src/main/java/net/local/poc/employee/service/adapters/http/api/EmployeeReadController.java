package net.local.poc.employee.service.adapters.http.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.employee.service.adapters.http.queries.ListAllEmployeeQuery;
import net.local.poc.employee.service.adapters.http.queries.ListByDepartmentQuery;
import net.local.poc.employee.service.adapters.http.queries.ListByOrganizationQuery;
import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/employees")
@ConditionalOnProperty(prefix = "cqrs", name = "read", havingValue = "true")
public class EmployeeReadController {
    
    private final ServiceBus serviceBus;

    public EmployeeReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> listAll() {
        var query = new ListAllEmployeeQuery();
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }

    @GetMapping(path = "/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponse>> listByDepartment(@Valid @NotNull @PathVariable(name = "departmentId") String departmentId) {
        var query = new ListByDepartmentQuery();
            query.setDepartmentId(departmentId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }

    @GetMapping(path = "/organization/{organizationId}")
    public ResponseEntity<List<EmployeeResponse>> listByOrganization(@Valid @NotNull @PathVariable(name = "organizationId") String organizationId) {
        var query = new ListByOrganizationQuery();
            query.setOrganizationId(organizationId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }
}
