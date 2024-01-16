package net.local.poc.department.service.application.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Department {
    
    private String departmentId;
    private String departmentName;
    private String organizationId;
}
