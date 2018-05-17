package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.service.dto.request.CustomerDto;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> findAll();

    Transaction create(CustomerDto customerDto, String projectDetailId);

    void destroy(String transactionId, String customerId);

    Transaction getOneByProjectDetail(String id);
}
