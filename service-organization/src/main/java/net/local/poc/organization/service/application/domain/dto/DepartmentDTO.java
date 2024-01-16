package net.local.poc.organization.service.application.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDTO {
    private String departmentId;
    private String departmentName;
}
