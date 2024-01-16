package net.local.poc.employee.service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.employee.service.application.ports.outgoing.DeleteEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.LoadEmployeePort;
import net.local.poc.employee.service.application.ports.outgoing.SaveEmployeePort;
import net.local.poc.employee.service.application.services.EmployeeManager;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public EmployeeManager manager(LoadEmployeePort loadEmployeePort, SaveEmployeePort saveEmployeePort, DeleteEmployeePort deleteEmployeePort) {
        return new EmployeeManager(loadEmployeePort, saveEmployeePort, deleteEmployeePort);
    }
}
