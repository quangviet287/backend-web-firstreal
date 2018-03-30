package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.repository.ProjectDetailRepository;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ProjectDetail> getOne(String id) {
        return projectDetailRepository.findById(id);
    }

    @Override
    public ProjectDetail save(ProjectDetail projectDetail) {
        return projectDetailRepository.save(projectDetail);
    }
}
