package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.repository.ProjectDetailRepository;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

    private final ProjectDetailRepository projectDetailRepository;

    private EmployeeService employeeService;

    public ProjectDetailServiceImpl(ProjectDetailRepository projectDetailRepository) {
        this.projectDetailRepository = projectDetailRepository;
    }


    @Override
    public List<ProjectDetail> findAllDetail() {
        return projectDetailRepository.findAll();
    }

    @Override
    public ProjectDetail getOne(String id) {
        return projectDetailRepository.findById(id).get();
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
    public List<ProjectDetail> getAllSoldByEmployee(Employee employee) {
            return projectDetailRepository.getAllByStateAndEmployee(employee);
    }

    @Override
    public List<ProjectDetail> getAllByEmployee(Employee employee) {
        return projectDetailRepository.getAllEmployee(employee);
    }

    @Override
    public List<ProjectDetail> getAllByDirection(String direction) {
        return projectDetailRepository.getAllByDirection(direction);
    }

    @Override
    public List<ProjectDetail> getAllByPrice(String price) {
        return projectDetailRepository.getAllByPrice(price);
    }

    @Override
    public List<ProjectDetail> getAllBySize(int size) {
        return projectDetailRepository.findAllBySize(size);
    }

    @Override
    public List<ProjectDetail> findAllBySizeAndDirectionAndPrice(int size, String direction, String price) {
        return projectDetailRepository.findAllBySizeAndDirectionAndPrice(size,direction,price);
    }

}
