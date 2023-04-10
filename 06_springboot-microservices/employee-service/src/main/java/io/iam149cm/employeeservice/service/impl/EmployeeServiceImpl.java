package io.iam149cm.employeeservice.service.impl;

import io.iam149cm.employeeservice.dto.APIResponseDto;
import io.iam149cm.employeeservice.dto.DepartmentDto;
import io.iam149cm.employeeservice.dto.EmployeeDto;
import io.iam149cm.employeeservice.entity.Employee;
import io.iam149cm.employeeservice.exception.ResourceNotFoundException;
import io.iam149cm.employeeservice.repository.EmployeeRepository;
import io.iam149cm.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = mapToDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        ResponseEntity<DepartmentDto> responseEntity =
                restTemplate.getForEntity(
                        "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                        DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = mapToDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    private EmployeeDto mapToDto(Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }

    private Employee mapToEntity(EmployeeDto employeeDto) {
        return mapper.map(employeeDto, Employee.class);
    }
}
