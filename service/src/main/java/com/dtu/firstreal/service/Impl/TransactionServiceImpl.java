package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Customer;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.entity.Transaction;
import com.dtu.firstreal.repository.CustomerRepository;
import com.dtu.firstreal.repository.ProjectDetailRepository;
import com.dtu.firstreal.repository.TransactionRepository;
import com.dtu.firstreal.service.TransactionService;
import com.dtu.firstreal.service.dto.request.CustomerDto;
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

    @Autowired
    ProjectDetailRepository projectDetailRepository;

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
        ProjectDetail projectDetail = projectDetailRepository.findById(projectDetailId).get();
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setAge(customerDto.getAge());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setSex(customerDto.getSex());
        customerRepository.save(customer);
        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setProjectDetail(projectDetail);
        transaction.setDateCreate(new Date());
        return transactionRepository.save(transaction);
    }

    @Override
    public void destroy(String transactionId, String customerId) {
        transactionRepository.deleteById(transactionId);
        customerRepository.deleteById(customerId);
    }

    @Override
    public Transaction getOneByProjectDetail(ProjectDetail projectDetail) {
        return transactionRepository.getOneByProjectDetailId(projectDetail);
    }
}
