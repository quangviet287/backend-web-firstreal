package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, String> {
    List<ProjectDetail> findAll();
}
