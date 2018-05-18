package com.dtu.firstreal.controller;

import com.dtu.firstreal.service.dto.request.LoginDto;
import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
