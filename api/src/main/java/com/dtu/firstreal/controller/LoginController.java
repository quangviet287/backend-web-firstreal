package com.dtu.firstreal.controller;

import Model.LoginDto;
import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto){
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        Employee employee = employeeService.getEmployeeByUsernameAndPassword(username,password);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.ok().build();
    }
}
