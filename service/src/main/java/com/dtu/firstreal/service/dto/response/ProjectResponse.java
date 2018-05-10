package com.dtu.firstreal.service.dto.response;

public class ProjectResponse {
    private String projectId;

    public ProjectResponse(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
