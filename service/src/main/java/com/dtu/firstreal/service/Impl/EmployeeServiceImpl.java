package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.repository.EmployeeRepository;
import com.dtu.firstreal.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeById(Employee employee) {
//        employee = employeeRepository.findById(id).get();
        employeeRepository.save(employee);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

}
