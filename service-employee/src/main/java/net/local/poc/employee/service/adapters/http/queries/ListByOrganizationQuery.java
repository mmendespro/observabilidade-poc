package net.local.poc.employee.service.adapters.http.queries;

import java.util.List;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.library.cqrs.Query;

public class ListByOrganizationQuery implements Query {
    
    private String organizationId;
    private List<EmployeeResponse> result;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public List<EmployeeResponse> getResult() {
        return result;
    }
    
    public void setResult(List<EmployeeResponse> result) {
        this.result = result;
    }
}
