package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.repository.EmployeeRepository;
import com.dtu.firstreal.repository.ProjectDetailRepository;
import com.dtu.firstreal.repository.ProjectRepository;
import com.dtu.firstreal.repository.TransactionRepository;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.service.dto.request.ProjectDetailDto;
import com.dtu.firstreal.service.dto.response.ProjectDetailResponse;
import com.dtu.firstreal.service.exception.EmployeeNotFoundException;
import com.dtu.firstreal.service.exception.ProjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

    Logger logger = LoggerFactory.getLogger(ProjectDetailServiceImpl.class);
    @Value("${image.directory}")
    private String imageDirectory;
    private final ProjectDetailRepository projectDetailRepository;
    @Autowired
    private  ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private Environment env;


    public ProjectDetailServiceImpl(ProjectDetailRepository projectDetailRepository) {
        this.projectDetailRepository = projectDetailRepository;
    }


    @Override
    public List<ProjectDetail> findAllDetail() {
        return projectDetailRepository.findAllByState();
    }

    @Override
    public List<ProjectDetail> AdminFindAllByProjectId(String id) {
        Project project = projectRepository.findById(id).get();
        return projectDetailRepository.AdminFindAllByProject(project);
    }

    @Override
    public List<ProjectDetail> findAllByProjectId(String id) {
        Project project = projectRepository.findById(id).get();
        return projectDetailRepository.findAllByProject(project);
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

    @Override
    public ProjectDetailResponse createProject(ProjectDetailDto projectDetailDto) {

        ProjectDetail projectDetail = new ProjectDetail();
        Project project = projectRepository.findById(projectDetailDto.getProjectId()).orElseThrow(()-> new ProjectNotFoundException());
        Employee employee = employeeRepository.findById(projectDetailDto.getEmployeeId()).orElseThrow(()-> new EmployeeNotFoundException());
        String imageDirectory = getImageDirectory();

        String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + projectDetailDto.getImage().getType();
        projectDetail.setEmployee(employee);
        projectDetail.setProject(project);
        projectDetail.setImageProjectDetailUrl(imageDirectory+imageName);
        projectDetail.setState(projectDetailDto.getState());
        projectDetail.setLocation(projectDetailDto.getLocation());
        projectDetail.setDirection(projectDetailDto.getDirection());
        projectDetail.setSize(projectDetailDto.getSize());
        projectDetail.setPrice(projectDetailDto.getPrice());
        projectDetail.setProjectDetailName(projectDetailDto.getProjectDetailName());

        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(projectDetailDto.getImage().getImage())))
            ;
            ImageIO.write(img, projectDetailDto.getImage().getType(), new FileOutputStream(projectDetail.getImageProjectDetailUrl()));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }


        projectDetail = projectDetailRepository.save(projectDetail);
         return new ProjectDetailResponse(projectDetail.getId());

    }

    @Override
    public void deleteAllByProject(Project project) {
       // Project project = projectRepository.getOne(id);
        projectDetailRepository.deleteByProject(project);
        List<ProjectDetail> projectDetail = projectDetailRepository.findAllByProject(project);
        for (ProjectDetail detail : projectDetail){
            transactionRepository.deleteByProjectDetail(detail);
        }
    }

    @Override
    public void deleteAllByEmployee(String id) {
        projectDetailRepository.deleteAllByEmployee(employeeRepository.getOne(id));
    }

    private String getImageDirectory() {
        return env.getProperty("image.directory");
    }
}
