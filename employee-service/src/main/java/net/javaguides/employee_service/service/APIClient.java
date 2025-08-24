package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Use service id can help to use the load balancer to call the rest API dynamically (use available port)
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode) ;
}