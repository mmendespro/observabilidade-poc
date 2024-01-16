package net.local.poc.employee.service.application.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String employeeId;
    private String employeeName;
    private String departmentId;
    private String organizationId;
}
