package net.local.poc.employee.service.web.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.employee.service.domain.Employee;
import net.local.poc.employee.service.service.EmployeeService;
import net.local.poc.employee.service.web.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> loadAll() {
        return ResponseEntity.ok(service.loadAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> loadById(@PathVariable Long id) {
        Employee employee = service.load(id).orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.ok(employee);
    }
}
