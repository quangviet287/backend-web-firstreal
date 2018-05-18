package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.service.dto.request.EmployeeDto;
import com.dtu.firstreal.service.dto.response.EmployeeResponse;

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
    EmployeeResponse create(EmployeeDto employeeDto);
    Employee getOneByName(String employeeName);

}
