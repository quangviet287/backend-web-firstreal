package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Address;
import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.entity.ProjectType;
import com.dtu.firstreal.repository.AddressRepository;
import com.dtu.firstreal.repository.ProjectRepository;
import com.dtu.firstreal.repository.ProjectTypeRepository;
import com.dtu.firstreal.service.ProjectService;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.request.ProjectDto;
import com.dtu.firstreal.service.dto.response.ProjectResponse;
import com.dtu.firstreal.service.dto.response.ProjectDtoResponse;
import com.dtu.firstreal.service.exception.AddressNotFoundException;
import com.dtu.firstreal.service.exception.ProjectTypeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProjectServiceImpl implements ProjectService{

    Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Value("${image.directory}")
    private String imageDirectory;

    @Autowired
    private Environment env;

    private final ProjectRepository projectRepository;
    private final ProjectTypeRepository projectTypeRepository;
    private final AddressRepository addressRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectTypeRepository projectTypeRepository, AddressRepository addressRepository) {
        this.projectRepository = projectRepository;
        this.projectTypeRepository = projectTypeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<ProjectDtoResponse> findAllProject() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDtoResponse> responses = new ArrayList<>();
        for(Project project : projects){
            ProjectDtoResponse projectResponse = new ProjectDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectResponse.setImage(imageDto);
            projectResponse.setAddressId(project.getAddress().getId());
            projectResponse.setProjectTypeId(project.getProjectType().getId());
            projectResponse.setDescription(project.getDescription());
            projectResponse.setProjectId(project.getId());
            projectResponse.setProjectName(project.getProjectName());
            try{
                String imageType = project.getImageProfileUrl().substring(project.getImageProfileUrl().lastIndexOf(".")+1);
                BufferedImage originalImage =
                        ImageIO.read(new File(project.getImageProfileUrl()));

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( originalImage, imageType, baos );
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                imageDto.setImage(Base64Utils.encodeToString(imageInByte));
                imageDto.setType(imageType);
                baos.close();

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            responses.add(projectResponse);
        }
        return responses;
    }

    @Override
    public Project getOne(String id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public Project getOneByProjectName(String projectName) {
        return projectRepository.getOneByProjectName(projectName);
    }

    @Override
    public ProjectResponse create(ProjectDto projectDto) {
        Project project = new Project();
        String imageDirectory = getImageDirectory();
        Address address = addressRepository.findById(projectDto.getAddressId()).orElseThrow(()-> new AddressNotFoundException());
        ProjectType projectType = projectTypeRepository.findById(projectDto.getProjectTypeId()).orElseThrow(()->new ProjectTypeNotFoundException());
        String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + projectDto.getImage().getType();
        project.setAddress(address);
        project.setProjectType(projectType);
        project.setDescription(projectDto.getDescription());
        project.setImageProfileUrl(imageDirectory+imageName);
        project.setProjectName(projectDto.getProjectName());

        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(projectDto.getImage().getImage())))
            ;
            ImageIO.write(img, projectDto.getImage().getType(), new FileOutputStream(project.getImageProfileUrl()));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        project = projectRepository.save(project);
        return new ProjectResponse(project.getId());
    }

    private String getImageDirectory() {
        return env.getProperty("image.directory");
    }
}
