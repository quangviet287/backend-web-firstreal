package com.dtu.firstreal.service.dto.response;

public class ProjectDetailResponse {
    private String projectDetailId;

    public ProjectDetailResponse(String projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    public String getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(String projectDetailId) {
        this.projectDetailId = projectDetailId;
    }
}
