package net.local.poc.employee.service.application.ports.incoming;

import net.local.poc.employee.service.application.domain.Employee;

public interface ShowEmployeeUseCase {
    Employee show(String employeeId);
}
