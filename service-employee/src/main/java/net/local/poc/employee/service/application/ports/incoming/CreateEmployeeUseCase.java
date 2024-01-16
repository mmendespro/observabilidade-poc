package net.local.poc.employee.service.application.ports.incoming;

public interface CreateEmployeeUseCase {
    void create(String employeeId, String employeeName, String departmentId, String organizationId);
}
