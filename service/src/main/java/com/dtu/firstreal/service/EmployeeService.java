package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findEmployeeById(String id);
    boolean addEmployee(Employee employee);
}
