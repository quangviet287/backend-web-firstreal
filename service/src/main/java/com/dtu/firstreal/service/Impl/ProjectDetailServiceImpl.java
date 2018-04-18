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

    @Override
    public ProjectDetail getOne(String id) {
        return projectDetailRepository.getOne(id);
    }

    @Override
    public ProjectDetail save(ProjectDetail projectDetail) {
        return projectDetailRepository.save(projectDetail);
    }

    @Override
    public void delete(ProjectDetail projectDetail) {
        projectDetailRepository.delete(projectDetail);
    }

    @Override
    public ProjectDetail getOneByName(String projectDetailName) {
        return projectDetailRepository.getOneByProjectDetailName(projectDetailName);
    }

    @Override
    public List<ProjectDetail> getByState() {
        List<ProjectDetail> details = projectDetailRepository.getAllByState();
        return details;
    }

    @Override
    public List<ProjectDetail> getByEmployeeId(String id) {
        return projectDetailRepository.getAllByStateAndEmployee(id);
    }
}
