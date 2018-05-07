package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer customer);
}
