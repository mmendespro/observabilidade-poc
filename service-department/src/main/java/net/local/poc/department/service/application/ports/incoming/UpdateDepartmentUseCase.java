package net.local.poc.department.service.application.ports.incoming;

public interface UpdateDepartmentUseCase {
    void update(String departmentId, String departmentName, String orgnizationId);
}
