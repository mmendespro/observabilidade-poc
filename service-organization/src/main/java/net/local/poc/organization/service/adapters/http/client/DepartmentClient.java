package net.local.poc.organization.service.adapters.http.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.local.poc.organization.service.application.domain.dto.DepartmentDTO;

@FeignClient(name = "service-department", url = "${services.department_url}")
public interface DepartmentClient  {

    @GetMapping( "/organization/{organizationId}")
    ResponseEntity<List<DepartmentDTO>> findByOrganization(@PathVariable String organizationId);
}
