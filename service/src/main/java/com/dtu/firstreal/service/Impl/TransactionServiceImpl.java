package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Bill;
import com.dtu.firstreal.repository.BillRepository;
import com.dtu.firstreal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    BillRepository billRepository;

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }
}
