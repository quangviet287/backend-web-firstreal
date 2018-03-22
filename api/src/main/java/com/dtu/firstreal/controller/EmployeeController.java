package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constants.URI_API)
public class EmployeeController  {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = Constants.URI_EMPLOYEES)
    @ResponseBody
    public ResponseEntity<Object> getAllEmployees(){
        log.debug("Get all employees");

        List<Employee> employees =employeeService.findAllEmployee();

        if(employees == null){
            return new ResponseEntity<>("employees not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
//    @PostMapping("/employee")

}
