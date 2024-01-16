package net.local.poc.employee.service.application.ports.outgoing;

import net.local.poc.employee.service.application.domain.Employee;

public interface SaveEmployeePort {
    void save(Employee employee);
}
