package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.repository.TransactionRepository;
import com.dtu.firstreal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getOneByProjectDetailsId(String projectDetailsId) {
        return transactionRepository.getOneByProjectDetailId(projectDetailsId);
    }
}
