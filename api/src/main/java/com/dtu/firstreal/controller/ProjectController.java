package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.service.ProjectService;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.request.ProjectDto;
import com.dtu.firstreal.service.dto.response.ProjectDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @Autowired
    private Environment env;
    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAllProject() {
        List<ProjectDtoResponse> projects = projectService.findAllProject();
        if (projects == null) {
            return new ResponseEntity<>("No project found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @GetMapping(value = "/getOne/{id}")
    public ResponseEntity<Object> getOneProject(@PathVariable("id") String id){
        Project project = projectService.getOne(id);
        if (project == null){
            return new ResponseEntity<>("no project found", HttpStatus.NOT_FOUND);
        }else {
            ProjectDtoResponse projectDtoResponse = new ProjectDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectDtoResponse.setImage(imageDto);
            projectDtoResponse.setAddressId(project.getAddress().getId());
            projectDtoResponse.setProjectTypeId(project.getProjectType().getId());
            projectDtoResponse.setDescription(project.getDescription());
            projectDtoResponse.setProjectId(project.getId());
            projectDtoResponse.setProjectName(project.getProjectName());
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
            return new ResponseEntity<>(projectDtoResponse, HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectDto projectDto){
        String projectName = projectDto.getProjectName();
        if(projectService.getOneByProjectName(projectName)==null){
            return new ResponseEntity<>(projectService.create(projectDto), HttpStatus.OK);
        }
        return new ResponseEntity<>("Project was exits", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable(value = "id") String id, @Valid @RequestBody ProjectDto projectForm){
        Project project = projectService.getOne(id);
        if (project == null){
            return new ResponseEntity<>("no project found", HttpStatus.NOT_FOUND);
        }else{
            String imageDirectory = env.getProperty("image.directory");
            String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + projectForm.getImage().getType();
            project.setDescription(projectForm.getDescription());
            project.setImageProfileUrl(imageDirectory+imageName);
            project.setProjectName(projectForm.getProjectName());
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(projectForm.getImage().getImage())))
                ;
                ImageIO.write(img, projectForm.getImage().getType(), new FileOutputStream(project.getImageProfileUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            projectService.updateProject(project);
            return ResponseEntity.ok().build();
        }

    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") String id){
        Project project = projectService.getOne(id);
        if(project == null){
            return new ResponseEntity<>("no project found", HttpStatus.NOT_FOUND);
        }
        projectService.deleteProject(project);
        return ResponseEntity.ok().build();
    }
}
