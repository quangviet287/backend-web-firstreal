package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.repository.ProjectRepository;
import com.dtu.firstreal.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }
}
