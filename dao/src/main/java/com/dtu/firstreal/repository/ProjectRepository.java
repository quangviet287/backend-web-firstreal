package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findAll();
    Optional<Project> findById(String id);
}
