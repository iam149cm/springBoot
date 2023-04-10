package io.iam149cm.employeeservice.service;

import io.iam149cm.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    // copied from DepartmentController.java
    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);

}
