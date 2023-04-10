package io.iam149cm.departmentservice.service.impl;

import io.iam149cm.departmentservice.dto.DepartmentDto;
import io.iam149cm.departmentservice.entity.Department;
import io.iam149cm.departmentservice.exception.ResourceNotFoundException;
import io.iam149cm.departmentservice.repository.DepartmentRepository;
import io.iam149cm.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper mapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert departmentDto to department entity
        Department department = mapToEntity(departmentDto);

        // save department entity to database
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = mapToDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department =
                departmentRepository.findByDepartmentCode(departmentCode);
        if(department == null) {
            throw new ResourceNotFoundException("department", "department Code", departmentCode);
        }

        DepartmentDto departmentDto = mapToDto(department);
        return departmentDto;
    }

    private DepartmentDto mapToDto(Department department) {
        return mapper.map(department, DepartmentDto.class);
    }

    private Department mapToEntity(DepartmentDto departmentDto) {
        return mapper.map(departmentDto, Department.class);
    }
}
