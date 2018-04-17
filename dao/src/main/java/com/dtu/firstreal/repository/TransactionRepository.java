package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Transaction getOneByProjectDetailId(String projectDetailId);
}
