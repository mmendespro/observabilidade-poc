package net.local.poc.department.service.adapters.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.department.service.application.domain.Department;
import net.local.poc.department.service.application.ports.outgoing.DeleteDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.LoadDepartmentPort;
import net.local.poc.department.service.application.ports.outgoing.SaveDepartmentPort;

@Repository
public class DepartmentRepository implements LoadDepartmentPort, SaveDepartmentPort, DeleteDepartmentPort {

    private Map<String,Department> inMemoryDB = new HashMap<>();

    @Override
    public Optional<Department> load(String departmentId) {
        return Optional.ofNullable(inMemoryDB.get(departmentId));
    }

    @Override
    public List<Department> loadByOrganization(String organizationId) {
        return inMemoryDB.values()
                         .stream()
                         .filter(dep -> organizationId.equals(dep.getOrganizationId()))
                         .collect(Collectors.toList());
    }

    @Override
    public void save(Department department) {
        inMemoryDB.putIfAbsent(department.getDepartmentId(), department);
    }

    @Override
    public void delete(String departmentId) {
        inMemoryDB.remove(departmentId);
    }
    
}
