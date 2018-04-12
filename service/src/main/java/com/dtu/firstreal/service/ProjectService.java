package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAllProject();
    Project getOne(String id);
    Project createProject(Project project);
    Project updateProject(Project project);
    void deleteProject(Project project);
    Project getOneByProjectName(String projectName);
}
