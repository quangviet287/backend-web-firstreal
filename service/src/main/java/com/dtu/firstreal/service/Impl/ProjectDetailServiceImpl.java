package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.repository.ProjectDetailRepository;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

    private final ProjectDetailRepository projectDetailRepository;

    public ProjectDetailServiceImpl(ProjectDetailRepository projectDetailRepository) {
        this.projectDetailRepository = projectDetailRepository;
    }


    @Override
    public List<ProjectDetail> findAllDetail() {
        return projectDetailRepository.findAll();
    }
}
