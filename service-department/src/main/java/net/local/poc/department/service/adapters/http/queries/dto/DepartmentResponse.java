package net.local.poc.department.service.adapters.http.queries.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {
    private String departmentId;
    private String departmentName;
}
