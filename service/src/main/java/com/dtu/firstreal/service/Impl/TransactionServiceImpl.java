package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Customer;
import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.repository.CustomerRepository;
import com.dtu.firstreal.repository.TransactionRepository;
import com.dtu.firstreal.service.TransactionService;
import com.dtu.firstreal.service.dto.request.CustomerDto;
import com.dtu.firstreal.service.dto.request.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction create(CustomerDto customerDto, String projectDetailId) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setAge(customerDto.getAge());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setSex(customerDto.getSex());
        customerRepository.save(customer);
        String customerId = customer.getId();
        TransactionDto transaction = new TransactionDto();
        transaction.setCustomerId(customerId);
        transaction.setProjectDetailId(projectDetailId);
        transaction.setDateCreate(new Date());
        return null;
    }
}
