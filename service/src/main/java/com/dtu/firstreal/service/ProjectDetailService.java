package com.dtu.firstreal.service;

import com.dtu.firstreal.entity.ProjectDetail;

import java.util.List;

public interface ProjectDetailService {
    List<ProjectDetail> findAllDetail();

    ProjectDetail getOne(String id);

    ProjectDetail save(ProjectDetail projectDetail);

    void delete(ProjectDetail projectDetail);

    ProjectDetail getOneByName(String projectDetailName);

    List<ProjectDetail> getByState();

    List<ProjectDetail> getByEmployeeId(String id);

    List<ProjectDetail> getAllByDirection(String direction);

    List<ProjectDetail> getAllByPrice(String price);

    List<ProjectDetail> getAllBySize(int size);


    List<ProjectDetail> findAllBySizeAndDirectionAndPrice(int size, String direction, String price);

}
