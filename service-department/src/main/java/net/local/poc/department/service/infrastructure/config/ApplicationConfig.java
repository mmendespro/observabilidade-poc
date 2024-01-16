package net.local.poc.department.service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.department.service.application.ports.outgoing.DeleteDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentEmployeesPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.SaveDepartmentPort;
import net.local.poc.department.service.application.services.DepartmentManager;

@Configuration
public class ApplicationConfig {

    @Bean
    public DepartmentManager manager(LoadDepartmentPort loadDepartmentPort, LoadDepartmentEmployeesPort loadDepartmentEmployeesPort, SaveDepartmentPort saveDepartmentPort, DeleteDepartmentPort deleteDepartmentPort) {
        return new DepartmentManager(loadDepartmentPort, loadDepartmentEmployeesPort, saveDepartmentPort, deleteDepartmentPort);
    }
}
