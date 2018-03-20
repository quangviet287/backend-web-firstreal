package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
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
public class ProjectDetailController {
    private static final Logger log = LoggerFactory.getLogger(ProjectDetailController.class);

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = Constants.URI_PROJECT_DETAIL)
    @ResponseBody
    public ResponseEntity<Object> getAllProjectDetail(){
        log.debug("Get all details");
        List<ProjectDetail> projectDetails = projectDetailService.findAllDetail();

        if(projectDetails == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectDetails,HttpStatus.OK);
    }

}
