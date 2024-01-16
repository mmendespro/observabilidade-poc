package net.local.poc.department.service.adapters.http.queries;

import java.util.List;

import net.local.poc.department.service.adapters.http.queries.dto.DepartmentResponse;
import net.local.poc.library.cqrs.Query;

public class ListByOrganizationQuery implements Query {
    
    private String organizationId;
    private List<DepartmentResponse> result;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public List<DepartmentResponse> getResult() {
        return result;
    }
    
    public void setResult(List<DepartmentResponse> result) {
        this.result = result;
    }
}
