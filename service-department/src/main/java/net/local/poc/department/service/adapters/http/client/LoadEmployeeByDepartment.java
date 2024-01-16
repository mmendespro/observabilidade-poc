package net.local.poc.department.service.adapters.http.client;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.department.service.application.domain.dto.EmployeeDTO;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentEmployeesPort;

@Slf4j
@Component
public class LoadEmployeeByDepartment implements LoadDepartmentEmployeesPort {
    
    private final EmployeeClient client;
    
    public LoadEmployeeByDepartment(EmployeeClient client) {
        this.client = client;
    }

    @Override
    public List<EmployeeDTO> load(String departmentId) {
        log.info("Loading employees from department {}", departmentId);
        return client.buscar(departmentId).getBody();
    }
    
}
