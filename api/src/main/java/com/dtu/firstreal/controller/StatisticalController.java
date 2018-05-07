package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statistical")
public class StatisticalController {
    @Autowired
    ProjectDetailService projectDetailService;

    @Autowired
    EmployeeService employeeService;
    @GetMapping(value = "/getAllSold")
    public ResponseEntity<Object> statisticalAllDetailSold(){
        List<ProjectDetail> lists = projectDetailService.getByState();
        if(lists == null){
            return ResponseEntity.notFound().build();
        }else return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllSoldByEmployee/{id}")
    public ResponseEntity<Object> statisticalDetailSoldByEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        List<ProjectDetail> details = projectDetailService.getAllSoldByEmployee(employee);
        if(details == null){
            return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(details,HttpStatus.OK);
    }
    @GetMapping(value = "/getAllByEmployee/{id}")
    public ResponseEntity<Object> statisticalAllDetailByEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        List<ProjectDetail> details = projectDetailService.getAllByEmployee(employee);
        if(details == null){
            return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(details,HttpStatus.OK);
    }
}
