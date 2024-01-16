package net.local.poc.employee.service.adapters.http.queries;

import net.local.poc.employee.service.adapters.http.queries.dto.EmployeeResponse;
import net.local.poc.library.cqrs.Query;

public class ListByEmployeeIdQuery implements Query {
    
    private String employeeId;
    private EmployeeResponse result;
    
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public EmployeeResponse getResult() {
        return result;
    }
    public void setResult(EmployeeResponse result) {
        this.result = result;
    }

}
