package io.iam149cm.employeeservice.service;

import io.iam149cm.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 호출 할 API 의 URL 을 명시하지 않고, application.properties 에 등록된 service id 만 전달하면
// Feign Client 가 알아서 해당 서비스의 API 를 호출한다.
// (Eureka Server 에 등록된 서비스만 가능하며 Eureka Client 에 내장된 로드밸런서 모듈로 로드밸런싱 한다)
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    // copied from DepartmentController.java
    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);

}

