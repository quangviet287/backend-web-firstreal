package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.ProjectDetail;

import java.util.List;

public interface ProjectDetailService {
    List<ProjectDetail> findAllDetail();

    ProjectDetail getOne(String id);

    ProjectDetail save(ProjectDetail projectDetail);

    void delete(ProjectDetail projectDetail);

    ProjectDetail getOneByName(String projectDetailName);
}
