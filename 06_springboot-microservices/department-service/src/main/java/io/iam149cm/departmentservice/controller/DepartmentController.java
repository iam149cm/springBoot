package io.iam149cm.departmentservice.controller;

import io.iam149cm.departmentservice.dto.DepartmentDto;
import io.iam149cm.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Department Controller",
        description = "Department Controller Exposes REST APIs for Department Service")
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save department REST API
    @Operation(
            summary = "Save Department",
            description = "Save Department REST API"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Department Created Successfully"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    // Build get department by code REST API
    @Operation(
            summary = "Get Department",
            description = "Get Department REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Department Retrieved Successfully"
    )
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }




}
