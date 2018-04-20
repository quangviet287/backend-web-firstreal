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

    @Override
    public Project getOne(String id) {
        Project project = projectRepository.findById(id).get();
        return project;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public Project getOneByProjectName(String projectName) {
        return projectRepository.getOneByProjectName(projectName);
    }

}
