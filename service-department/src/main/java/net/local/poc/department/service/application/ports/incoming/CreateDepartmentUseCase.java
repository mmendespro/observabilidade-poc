package net.local.poc.department.service.application.ports.incoming;

public interface CreateDepartmentUseCase {
    void create(String departmentId, String departmentName, String orgnizationId);
}
