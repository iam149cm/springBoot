package io.iam149cm.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.iam149cm.employeeservice.dto.APIResponseDto;
import io.iam149cm.employeeservice.dto.DepartmentDto;
import io.iam149cm.employeeservice.dto.EmployeeDto;
import io.iam149cm.employeeservice.entity.Employee;
import io.iam149cm.employeeservice.exception.ResourceNotFoundException;
import io.iam149cm.employeeservice.repository.EmployeeRepository;
import io.iam149cm.employeeservice.service.APIClient;
import io.iam149cm.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = mapToDto(savedEmployee);
        return savedEmployeeDto;
    }

    /* Department 서비스가 다운되었을 때 500에러를 반환한다.
    * 이때, CircuitBreaker가 동작하고, fallbackMethod를 호출한다.
    * fallbackMethod는 CircuitBreaker가 동작할 때, 대신 호출되는 메서드이다.
    * CircuitBreaker가 동작하지 않았을 때, 정상적으로 호출된다.
    * */
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        // 1. Using RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity =
//                restTemplate.getForEntity(
//                        "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                        DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        // 2. Using WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        // 3. Using Feign Client
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = mapToDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) { // CircuitBreaker가 동작할 때, 대신 호출되는 fallback 메서드
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        // set Default Department
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

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
