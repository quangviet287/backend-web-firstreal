package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query(value = "select t from Transaction t where t.projectDetail =:projectDetail")
    Transaction getOneByProjectDetailId(@Param("projectDetail") ProjectDetail projectDetail);

    Transaction deleteByProjectDetail(ProjectDetail projectDetail);
}
