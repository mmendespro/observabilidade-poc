package net.local.poc.organization.service.adapters.http.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/organizations")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class OrganizationReadController {
    
    private final ServiceBus serviceBus;

    public OrganizationReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    /*
    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDetailResponse> detail(@Valid @NotNull @PathVariable(name = "departmentId") String departmentId) {
        var query = new DetailDepartmentQuery(departmentId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }
    */
}
