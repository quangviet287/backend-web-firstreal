package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAllProject() {

        log.debug("Get all project");

        List<Project> projects = projectService.findAllProject();

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
            return new ResponseEntity<>(project, HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createProject(@Valid @RequestBody  Project project){
        String projectName = project.getProjectName();
        if(projectService.getOneByProjectName(projectName)==null){
            projectService.createProject(project);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("Project was exits", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable(value = "id") String id, @Valid @RequestBody Project projectForm){
        Project project = projectService.getOne(id);
        if (project == null){
            return new ResponseEntity<>("no project found", HttpStatus.NOT_FOUND);
        }
        project.setProjectName(projectForm.getProjectName());
        project.setAddress(projectForm.getAddress());
        project.setDescription(projectForm.getDescription());
        Project projectUpdate = projectService.updateProject(project);
        return new ResponseEntity<>(projectUpdate, HttpStatus.OK);
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
