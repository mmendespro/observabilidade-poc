package net.local.poc.department.service.adapters.http.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.local.poc.department.service.application.domain.dto.EmployeeDTO;

@FeignClient(name = "service-employee", url = "${services.employee_url}")
public interface EmployeeClient  {

    @GetMapping( "/department/{departmentId}")
    ResponseEntity<List<EmployeeDTO>> buscar(@PathVariable String departmentId);
}
