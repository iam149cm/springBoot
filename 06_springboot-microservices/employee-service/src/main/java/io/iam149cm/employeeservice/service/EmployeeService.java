package io.iam149cm.employeeservice.service;

import io.iam149cm.employeeservice.dto.EmployeeDto;
public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
}
