package net.local.poc.employee.service.application.ports.incoming;

public interface UpdateEmployeeUseCase {
    void update(String employeeId, String employeeName, String departmentId, String organizationId);
}
