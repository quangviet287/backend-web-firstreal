package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.service.ProjectDetailService;
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

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = Constants.URI_TRANSACTION)
    public ResponseEntity<Object> getAllTransaction(){
        List<Transaction> transactions = transactionService.findAll();
        if(transactions == null){
            return ResponseEntity.notFound().build();
        }return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @PostMapping(value = Constants.URI_TRANSACTION)
    public ResponseEntity<Object> createTransaction(@Valid @RequestBody Transaction transactionForm){
        transactionService.save(transactionForm);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = Constants.URI_PROJECT_DETAIL_ID_UPDATE)
    public ResponseEntity<Object> updateState(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail != null){
            projectDetail.setState(true);
            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
