package net.local.poc.employee.service.adapters.http.queries.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
    private String employeeId;
    private String employeeName;
    private String departmentId;
    private String organizationId;
}
