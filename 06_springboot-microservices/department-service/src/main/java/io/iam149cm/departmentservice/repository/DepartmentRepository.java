package io.iam149cm.departmentservice.repository;

import io.iam149cm.departmentservice.entity.Department;
import io.iam149cm.departmentservice.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
