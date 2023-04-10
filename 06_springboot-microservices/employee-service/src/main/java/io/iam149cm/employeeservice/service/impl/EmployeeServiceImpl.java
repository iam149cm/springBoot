package io.iam149cm.employeeservice.service.impl;

import io.iam149cm.employeeservice.dto.EmployeeDto;
import io.iam149cm.employeeservice.entity.Employee;
import io.iam149cm.employeeservice.exception.ResourceNotFoundException;
import io.iam149cm.employeeservice.repository.EmployeeRepository;
import io.iam149cm.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = mapToDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        EmployeeDto employeeDto = mapToDto(employee);
        return employeeDto;
    }

    private EmployeeDto mapToDto(Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }

    private Employee mapToEntity(EmployeeDto employeeDto) {
        return mapper.map(employeeDto, Employee.class);
    }
}
