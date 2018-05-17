package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.service.TransactionService;
import com.dtu.firstreal.service.dto.request.CustomerDto;
import com.dtu.firstreal.service.dto.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAllTransaction(){
        List<Transaction> transactions = transactionService.findAll();
        if(transactions == null){
            return ResponseEntity.notFound().build();
        }return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping(value = "/getInforTransaction/{projectDetailId}")
    public ResponseEntity<?> getOneByProject(@PathVariable("projectDetailId") String projectDetailId){
        ProjectDetail projectDetail = projectDetailService.getOne(projectDetailId);
        if (projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            try {
                Transaction transaction = transactionService.getOneByProjectDetail(projectDetailId);
                return new ResponseEntity<>(transaction, HttpStatus.OK);
            }catch (RuntimeException e){
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createTransaction(@Valid @RequestBody Transaction transactionForm){
        transactionService.save(transactionForm);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/finish/{projectDetailId}")
    public ResponseEntity<Object> updateState(@PathVariable("projectDetailId") String projectDetailId){
        ProjectDetail projectDetail = projectDetailService.getOne(projectDetailId);
        if (projectDetail != null){
            projectDetail.setState(true);
            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/save/{projectDetailId}")
    public TransactionResponse saveTransaction(@Valid @RequestBody CustomerDto customerDto, @PathVariable("projectDetailId") String projectDetailId){
        Transaction transaction = transactionService.create(customerDto,projectDetailId);
        return new TransactionResponse(transaction.getId());
    }

    @DeleteMapping(value = "/destroy/{transactionId}+{customerId}")
    public ResponseEntity<?> destroyTransaction(@PathVariable("transactionId") String transactionId, @PathVariable("customerId") String customerId){
        transactionService.destroy(transactionId, customerId);
        return ResponseEntity.ok().build();
    }
}
