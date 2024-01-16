package net.local.poc.department.service.adapters.http.queries;

import net.local.poc.department.service.adapters.http.queries.dto.DepartmentDetailResponse;
import net.local.poc.library.cqrs.Query;

public class DetailDepartmentQuery implements Query {
    
    private final String departmentId;
    private DepartmentDetailResponse result;

    public DetailDepartmentQuery(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public DepartmentDetailResponse getResult() {
        return result;
    }

    public void setResult(DepartmentDetailResponse result) {
        this.result = result;
    }
}
