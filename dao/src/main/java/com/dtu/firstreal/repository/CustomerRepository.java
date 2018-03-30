package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
