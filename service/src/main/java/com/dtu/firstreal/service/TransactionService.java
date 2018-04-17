package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> findAll();

    Transaction getOneByProjectDetailsId(String projectDetailsId);
}
