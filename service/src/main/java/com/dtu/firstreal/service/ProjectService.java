package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.service.dto.request.ProjectDto;
import com.dtu.firstreal.service.dto.response.ProjectResponse;
import com.dtu.firstreal.service.dto.response.ProjectDtoResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectDtoResponse> findAllProject();
    Project getOne(String id);
    Project createProject(Project project);
    Project updateProject(Project project);
    void deleteProject(Project project);
    Project getOneByProjectName(String projectName);
    ProjectResponse create(ProjectDto projectDto);
}
