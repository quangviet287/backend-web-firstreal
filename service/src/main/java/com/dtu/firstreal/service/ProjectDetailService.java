package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.ProjectDetail;

import java.util.List;
import java.util.Optional;

public interface ProjectDetailService {
    List<ProjectDetail> findAllDetail();

    Optional<ProjectDetail> getOne(String id);

    ProjectDetail save(ProjectDetail projectDetail);

}
