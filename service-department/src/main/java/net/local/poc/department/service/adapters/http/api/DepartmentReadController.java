package net.local.poc.department.service.adapters.http.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.department.service.adapters.http.queries.DetailDepartmentQuery;
import net.local.poc.department.service.adapters.http.queries.ListByOrganizationQuery;
import net.local.poc.department.service.adapters.http.queries.dto.DepartmentDetailResponse;
import net.local.poc.department.service.adapters.http.queries.dto.DepartmentResponse;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/departments")
@ConditionalOnProperty(prefix = "cqrs", name = "read", havingValue = "true")
public class DepartmentReadController {
    
    private final ServiceBus serviceBus;

    public DepartmentReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDetailResponse> detail(@Valid @NotNull @PathVariable(name = "departmentId") String departmentId) {
        var query = new DetailDepartmentQuery(departmentId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }

    @GetMapping(path = "/organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponse>> listByOrganization(@Valid @NotNull @PathVariable(name = "organizationId") String organizationId) {
        var query = new ListByOrganizationQuery();
            query.setOrganizationId(organizationId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }

}
