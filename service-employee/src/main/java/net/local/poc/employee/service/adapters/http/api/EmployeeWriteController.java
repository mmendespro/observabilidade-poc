package net.local.poc.employee.service.adapters.http.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.employee.service.adapters.http.commands.CreateEmployeeCommand;
import net.local.poc.employee.service.adapters.http.commands.DeleteEmployeeCommand;
import net.local.poc.employee.service.adapters.http.commands.UpdateEmployeeCommand;
import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeRequest;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/employees")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class EmployeeWriteController {
    
    private final ServiceBus serviceBus;

    public EmployeeWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmployeeRequest request) {
        serviceBus.execute (
            new CreateEmployeeCommand(request.getEmployeeId(), 
                                      request.getEmployeeName(), 
                                      request.getDepartmentId(), 
                                      request.getOrganizationId())
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<String> update(@Valid @NotNull @PathVariable(name = "employeeId") String employeeId, @RequestBody EmployeeRequest request) {
        serviceBus.execute (
            new UpdateEmployeeCommand(employeeId, 
                                      request.getEmployeeName(), 
                                      request.getDepartmentId(), 
                                      request.getOrganizationId())
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<String> delete(@Valid @NotNull @PathVariable(name = "employeeId") String employeeId) {
        serviceBus.execute(new DeleteEmployeeCommand(employeeId));
        return ResponseEntity.noContent().build();
    }
}
