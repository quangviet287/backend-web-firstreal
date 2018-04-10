package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Bill;
import com.dtu.firstreal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transaction")
    public ResponseEntity<Object> creatTransaction(@Valid @RequestBody Bill bill){
        transactionService.save(bill);
        return ResponseEntity.ok().build();
    }
}
