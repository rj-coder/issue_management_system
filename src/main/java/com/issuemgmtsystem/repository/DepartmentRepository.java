package com.issuemgmtsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issuemgmtsystem.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	Optional<Department> findByDepartmentCode(Integer departmentCode);
}
