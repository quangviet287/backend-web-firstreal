package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Customer;
import com.dtu.firstreal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> findAll(){
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createCus(@Valid @RequestBody Customer customer){
        customerService.save(customer);
        return ResponseEntity.ok().build();
    }
}
