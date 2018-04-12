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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Constants.URI_API)
public class EmployeeController  {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = Constants.URI_EMPLOYEES)
    public ResponseEntity<Object> getAllEmployees(){
        log.debug("Get all employees");

        List<Employee> employees =employeeService.findAllEmployee();

        if(employees == null){
            return new ResponseEntity<>("employees not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping(value = Constants.URI_EMPLOYEE_ID)
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping(value = Constants.URI_EMPLOYEE)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        String username = employee.getUsername();
        Employee emp = employeeService.getEmployeeByUserName(username);
        if(emp == null){
            employeeService.save(employee);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("employee exits", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = Constants.URI_EMPLOYEE_ID)
    public ResponseEntity<Employee> updateInfor(@PathVariable(value = "id") String id, @Valid @RequestBody Employee employeeForm){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employee.setEmployeeName(employeeForm.getEmployeeName());
        employee.setSex(employeeForm.getSex());
        employee.setAge(employeeForm.getAge());
        employee.setPhoneNumber(employeeForm.getPhoneNumber());

        Employee employeeUpdate = employeeService.save(employee);
        return ResponseEntity.ok(employeeUpdate);
    }

    @DeleteMapping(value = Constants.URI_EMPLOYEE_ID)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = Constants.URI_EMPLOYEE_USERNAME)
    public ResponseEntity<Object> getEmployeeByUserName(@PathVariable("username") String username){
        Employee employee = employeeService.getEmployeeByUserName(username);
        if(employee == null){
            return new ResponseEntity<>("No employee found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
