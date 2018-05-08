package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.dto.request.ProjectDetailDto;
import com.dtu.firstreal.service.dto.response.ProjectDetailResponse;

import java.util.List;

public interface ProjectDetailService {
    List<ProjectDetail> findAllDetail();
    ProjectDetail getOne(String id);
    ProjectDetail save(ProjectDetail projectDetail);
    void delete(ProjectDetail projectDetail);
    ProjectDetail getOneByName(String projectDetailName);
    List<ProjectDetail> getByState();
    List<ProjectDetail> getAllSoldByEmployee(Employee employee);
    List<ProjectDetail> getAllByEmployee(Employee employee);
    List<ProjectDetail> getAllByDirection(String direction);
    List<ProjectDetail> getAllByPrice(String price);
    List<ProjectDetail> getAllBySize(int size);
    List<ProjectDetail> findAllBySizeAndDirectionAndPrice(int size, String direction, String price);
    ProjectDetailResponse createProject(ProjectDetailDto projectDetailDto);
    ProjectDetailResponse updateProject(ProjectDetailDto projectDetailDto);
}
