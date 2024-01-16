package net.local.poc.department.service.application.services;

import net.local.poc.department.service.application.domain.Department;
import net.local.poc.department.service.application.exceptions.DepartmentNotEmptyException;
import net.local.poc.department.service.application.exceptions.DepartmentNotFoundException;
import net.local.poc.department.service.application.exceptions.DuplicateKeyException;
import net.local.poc.department.service.application.ports.incoming.CreateDepartmentUseCase;
import net.local.poc.department.service.application.ports.incoming.DeleteDepartmentUseCase;
import net.local.poc.department.service.application.ports.incoming.UpdateDepartmentUseCase;
import net.local.poc.department.service.application.ports.outgoing.DeleteDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentEmployeesPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.SaveDepartmentPort;

public class DepartmentManager implements CreateDepartmentUseCase, UpdateDepartmentUseCase, DeleteDepartmentUseCase {
    
    private final LoadDepartmentPort loadDepartmentPort;
    private final LoadDepartmentEmployeesPort loadDepartmentEmployeesPort;
    private final SaveDepartmentPort saveDepartmentPort;
    private final DeleteDepartmentPort deleteDepartmentPort;

    public DepartmentManager(LoadDepartmentPort loadDepartmentPort, LoadDepartmentEmployeesPort loadDepartmentEmployeesPort, SaveDepartmentPort saveDepartmentPort, DeleteDepartmentPort deleteDepartmentPort) {
        this.loadDepartmentPort = loadDepartmentPort;
        this.loadDepartmentEmployeesPort = loadDepartmentEmployeesPort;
        this.saveDepartmentPort = saveDepartmentPort;
        this.deleteDepartmentPort = deleteDepartmentPort;
    }

    @Override
    public void create(String departmentId, String departmentName, String orgnizationId) {
        loadDepartmentPort.load(departmentId).ifPresent(dep -> { throw new DuplicateKeyException(); });
        
        var depto = Department.builder()
                              .departmentId(departmentId)
                              .departmentName(departmentName)
                              .organizationId(orgnizationId)
                              .build();

        saveDepartmentPort.save(depto);
    }

    @Override
    public void update(String departmentId, String departmentName, String orgnizationId) {
        loadDepartmentPort.load(departmentId).orElseThrow(DepartmentNotFoundException::new);

        var depto = Department.builder()
                              .departmentId(departmentId)
                              .departmentName(departmentName)
                              .organizationId(orgnizationId)
                              .build();

        saveDepartmentPort.save(depto);
    }

    @Override
    public void delete(String departmentId) {
        loadDepartmentPort.load(departmentId).orElseThrow(DepartmentNotFoundException::new);
        
        if(loadDepartmentEmployeesPort.load(departmentId).size() > 0) {
            throw new DepartmentNotEmptyException();
        }

        deleteDepartmentPort.delete(departmentId);
    }

}
