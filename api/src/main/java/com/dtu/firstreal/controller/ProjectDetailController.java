package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.ProjectDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/detail")
public class ProjectDetailController {
    private static final Logger log = LoggerFactory.getLogger(ProjectDetailController.class);

    @Autowired
    ProjectDetailService projectDetailService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAllProjectDetail(){
        log.debug("Get all details");
        List<ProjectDetail> projectDetails = projectDetailService.findAllDetail();

        if(projectDetails == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectDetails,HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{id}")
    public ResponseEntity<Object> getOneProjectDetail(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(projectDetail, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createProjectDetails(@Valid @RequestBody ProjectDetail projectDetail){
        String projectDetailName = projectDetail.getProjectDetailName();
        if(projectDetailService.getOneByName(projectDetailName)==null){
            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("Project details exits", HttpStatus.BAD_REQUEST);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateProjectDetails(@PathVariable("id") String id, @Valid @RequestBody ProjectDetail projectDetailForm){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if(projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            projectDetail.setPrice(projectDetailForm.getPrice());
            projectDetail.setSize(projectDetailForm.getSize());
            projectDetail.setDirection(projectDetailForm.getDirection());
            projectDetail.setEmployee(projectDetailForm.getEmployee());
            projectDetail.setLocation(projectDetailForm.getLocation());

            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteProjectDetails(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if(projectDetail == null){
            return ResponseEntity.notFound().build();
        }
        projectDetailService.delete(projectDetail);
        return ResponseEntity.ok().build();
    }
}
