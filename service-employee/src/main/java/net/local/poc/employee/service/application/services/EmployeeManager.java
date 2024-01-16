package net.local.poc.employee.service.application.services;

import net.local.poc.employee.service.application.domain.Employee;
import net.local.poc.employee.service.application.exceptions.DuplicateKeyException;
import net.local.poc.employee.service.application.exceptions.EmployeeNotFoundException;
import net.local.poc.employee.service.application.ports.incoming.CreateEmployeeUseCase;
import net.local.poc.employee.service.application.ports.incoming.DeleteEmployeeUseCase;
import net.local.poc.employee.service.application.ports.incoming.ShowEmployeeUseCase;
import net.local.poc.employee.service.application.ports.incoming.UpdateEmployeeUseCase;
import net.local.poc.employee.service.application.ports.outgoing.DeleteEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.SaveEmployeePort;

public class EmployeeManager implements CreateEmployeeUseCase, UpdateEmployeeUseCase, DeleteEmployeeUseCase, ShowEmployeeUseCase {
    
    private final LoadEmployeePort loadEmployeePort;
    private final SaveEmployeePort saveEmployeePort;
    private final DeleteEmployeePort deleteEmployeePort;

    public EmployeeManager(LoadEmployeePort loadEmployeePort, SaveEmployeePort saveEmployeePort, DeleteEmployeePort deleteEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
        this.saveEmployeePort = saveEmployeePort;
        this.deleteEmployeePort = deleteEmployeePort;
    }

    @Override
    public void create(String employeeId, String employeeName, String departmentId, String organizationId) {
        loadEmployeePort.load(employeeId).ifPresent(emp -> { throw new DuplicateKeyException(); });
        
        var employee = Employee.builder()
                               .employeeId(employeeId)
                               .employeeName(employeeName)
                               .departmentId(departmentId)
                               .organizationId(organizationId)
                               .build();
        
        saveEmployeePort.save(employee);
    }

    @Override
    public void update(String employeeId, String employeeName, String departmentId, String organizationId) {
        loadEmployeePort.load(employeeId).orElseThrow(EmployeeNotFoundException::new);
        
        var employee = Employee.builder()
                               .employeeId(employeeId)
                               .employeeName(employeeName)
                               .departmentId(departmentId)
                               .organizationId(organizationId)
                               .build();
        
        saveEmployeePort.save(employee);
    }

    @Override
    public void delete(String employeeId) {
        loadEmployeePort.load(employeeId).orElseThrow(EmployeeNotFoundException::new);
        deleteEmployeePort.delete(employeeId);
    }

    @Override
    public Employee show(String employeeId) {
        var employeeFound = loadEmployeePort.load(employeeId).orElseThrow(EmployeeNotFoundException::new);
        return employeeFound;
    }
}
