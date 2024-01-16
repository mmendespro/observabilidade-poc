package net.local.poc.organization.service.application.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private String employeeId;
    private String emplyeeName;
    private String departmentId;
}
