package net.local.poc.employee.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_EMPLOYEE", nullable = false)
    private Long employeeId;

    @Column(name = "DS_EMPLOYEE", nullable = false)
    private String employeeName;

    @Column(name = "VL_SALARY", nullable = false, precision=10, scale=2)
    private float salary;

    @Column(name = "FK_DEPARTMENT", nullable = false)
    private Long departmentId;

    @Column(name = "FK_ORGANIZATION", nullable = false)
    private Long organizationId;
}
