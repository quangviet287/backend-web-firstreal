package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findEmployeeById(String id);
    void createEmployee(Employee employee);
    void updateEmployeeById(Employee employee);
    Employee save(Employee employee);
    void delete(Employee employee);
    Employee getEmployeeByUserName(String username);
    Employee getEmployeeByUsernameAndPassword(String username, String password);
}
