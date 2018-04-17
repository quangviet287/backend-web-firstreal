package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.service.TransactionService;
import com.dtu.firstreal.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Constants.URI_API)
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = Constants.URI_TRANSACTION)
    public ResponseEntity<Object> getAllTransaction(){
        List<Transaction> transactions = transactionService.findAll();
        if(transactions == null){
            return ResponseEntity.notFound().build();
        }return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @PostMapping(value = Constants.URI_TRANSACTION)
    public ResponseEntity<Object> createTransaction(@Valid @RequestBody Transaction transactionForm){
        String projectDetailsId = transactionForm.getId();
        Transaction transaction = transactionService.getOneByProjectDetailsId(projectDetailsId);
        if(transaction == null){
            transactionService.save(transactionForm);
            return ResponseEntity.ok().build();
        }else return ResponseEntity.notFound().build();
    }
}
