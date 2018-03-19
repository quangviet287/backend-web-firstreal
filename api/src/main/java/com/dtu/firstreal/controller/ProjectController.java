package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.service.ProjectService;
import com.dtu.firstreal.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = Constants.URI_API)
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @GetMapping(value = Constants.URI_PROJECTS)
    @ResponseBody
    public ResponseEntity<Object> getAllProject() {

        log.debug("Get all project");

        List<Project> projects = projectService.findAllProject();

        if (projects == null) {
            return new ResponseEntity<>("No project found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
