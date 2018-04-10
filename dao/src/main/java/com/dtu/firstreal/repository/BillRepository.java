package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, String> {
}
