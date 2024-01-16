package net.local.poc.organization.service.adapters.http.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.library.cqrs.ServiceBus;
import net.local.poc.organization.service.adapters.http.command.CreateOrganizationCommand;

@RestController
@RequestMapping("/v1/organizations")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class OrganizationWriteController {
    
    private final ServiceBus serviceBus;

    public OrganizationWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateOrganizationCommand command) {
        serviceBus.execute (command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
