package net.local.poc.employee.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.poc.employee.service.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByOrganizationId(Long organizationId);
}
