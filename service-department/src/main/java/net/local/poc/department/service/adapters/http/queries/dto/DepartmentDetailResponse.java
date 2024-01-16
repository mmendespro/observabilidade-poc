package net.local.poc.department.service.adapters.http.queries.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import net.local.poc.department.service.application.domain.dto.EmployeeDTO;

@Data
@Builder
public class DepartmentDetailResponse {
    
    private String departmentId;
    private String departmentName;
    private List<EmployeeDTO> employees;
}
