package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Constants.URI_API)
public class ProjectDetailController {
    private static final Logger log = LoggerFactory.getLogger(ProjectDetailController.class);

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = Constants.URI_PROJECT_DETAIL)
    public ResponseEntity<Object> getAllProjectDetail(){
        log.debug("Get all details");
        List<ProjectDetail> projectDetails = projectDetailService.findAllDetail();

        if(projectDetails == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectDetails,HttpStatus.OK);
    }

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_ID)
    public ResponseEntity<Object> getOneProjectDetail(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(projectDetail, HttpStatus.OK);
        }
    }

    @PostMapping(value = Constants.URI_PROJECT_DETAIL)
    public ResponseEntity<Object> createProjectDetails(@Valid @RequestBody ProjectDetail projectDetail){
        String projectDetailName = projectDetail.getProjectDetailName();
        if(projectDetailService.getOneByName(projectDetailName)==null){
            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("Project details exits", HttpStatus.BAD_REQUEST);
    }


    @PutMapping(value = Constants.URI_PROJECT_DETAIL_ID)
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

    @DeleteMapping(value = Constants.URI_PROJECT_DETAIL_ID)
    public ResponseEntity<Object> deleteProjectDetails(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if(projectDetail == null){
            return ResponseEntity.notFound().build();
        }
        projectDetailService.delete(projectDetail);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_STATISTICAL)
    public ResponseEntity<Object> statistical(){
        List<ProjectDetail> lists = projectDetailService.getByState();
        if(lists == null){
            return ResponseEntity.notFound().build();
        }else return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_EMPLOYEE)
    public ResponseEntity<Object> statisticalByEmployee(@PathVariable("id") String id){
        List<ProjectDetail> details = projectDetailService.getByEmployeeId(id);
        if(details == null){
            return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(details,HttpStatus.OK);
    }
}
