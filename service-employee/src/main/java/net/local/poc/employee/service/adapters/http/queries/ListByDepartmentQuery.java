package net.local.poc.employee.service.adapters.http.queries;

import java.util.List;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.library.cqrs.Query;

public class ListByDepartmentQuery implements Query {
    
    private String departmentId;
    private List<EmployeeResponse> result;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    public List<EmployeeResponse> getResult() {
        return result;
    }
    
    public void setResult(List<EmployeeResponse> result) {
        this.result = result;
    }
}
