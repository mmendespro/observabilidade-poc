package net.local.poc.department.service.adapters.http.api;

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

import net.local.poc.department.service.adapters.http.commands.CreateDepartmentCommand;
import net.local.poc.department.service.adapters.http.commands.DeleteDepartmentCommand;
import net.local.poc.department.service.adapters.http.commands.UpdateDepartmentCommand;
import net.local.poc.library.cqrs.ServiceBus;


@RestController
@RequestMapping("/v1/departments")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class DepartmentWriteController {
    
    private final ServiceBus serviceBus;

    public DepartmentWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateDepartmentCommand command) {
        serviceBus.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<String> update(@Valid @NotNull @PathVariable(name = "departmentId") String employeeId, @RequestBody UpdateDepartmentCommand command) {
        serviceBus.execute(command);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<String> delete(@Valid @NotNull @PathVariable(name = "departmentId") String departmentId) {
        serviceBus.execute(new DeleteDepartmentCommand(departmentId));
        return ResponseEntity.noContent().build();
    }
}
