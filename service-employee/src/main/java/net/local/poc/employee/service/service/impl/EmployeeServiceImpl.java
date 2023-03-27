package net.local.poc.employee.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.employee.service.domain.Employee;
import net.local.poc.employee.service.repository.EmployeeRepository;
import net.local.poc.employee.service.service.EmployeeService;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> loadAll() {
        var result = repository.findAll();
        log.info("Found {} employee(s)", result.size());
        return result;
    }

    @Override
    public Optional<Employee> load(Long employeeId) {
        log.info("Finding details of employee with id {}", employeeId);
        return repository.findById(employeeId);
    }

    @Override
    public List<Employee> loadByDepartment(Long departmentId) {
        var result = repository.findByDepartmentId(departmentId);
        log.info("Found {} employee(s) in department with id {}", result.size(), departmentId);
        return result;
    }

    @Override
    public List<Employee> loadByOrganization(Long organizationId) {
        var result = repository.findByOrganizationId(organizationId);
        log.info("Found {} employee(s) in orgnization with id {}", result.size(), organizationId);
        return result;
    }

    @Override
    public void save(Employee employee) {
        log.info("Save employee {}", employee);
        repository.save(employee);
    }

    @Override
    public void delete(Long employeeId) {
        log.info("Delete employee with id {}", employeeId);
        repository.deleteById(employeeId);
    }    
}
