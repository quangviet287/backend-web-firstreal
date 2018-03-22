package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String>, CrudRepository<Employee, String> {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    List<Employee> findByNameAndAge(String employeeName, Integer employeeAge);
}
