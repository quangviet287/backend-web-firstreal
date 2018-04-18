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


    @PutMapping(value = Constants.URI_PROJECT_DETAIL_ID_UPDATE)
    public ResponseEntity<Object> updateState(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail != null){
            ProjectDetail projectDetailUpdate = new ProjectDetail();
            projectDetailUpdate.setState(true);
            projectDetailService.save(projectDetailUpdate);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
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

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_DIRECTION)
    public ResponseEntity<Object> getDetailsByDirection(@PathVariable("age") String age,@PathVariable("sex") Boolean sex){
//        String age = advisoryForm.getAge();
//        Boolean sex = advisoryForm.isSex();
        String direction;

        if(age.equals("Ty") && sex.equals(true)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Ty") && sex.equals(true)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Suu") && sex.equals(true)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Suu") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Dan") && sex.equals(true)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Dan") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Meo") && sex.equals(true)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Meo") && sex.equals(false)){
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Thin") && sex.equals(true)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Thin") && sex.equals(false)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Ti") && sex.equals(false)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Ti") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Ngo") && sex.equals(false)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Ngo") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Mui") && sex.equals(false)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Mui") && sex.equals(false)){
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Than") && sex.equals(false)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Than") && sex.equals(false)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Dau") && sex.equals(false)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Dau") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Tuat") && sex.equals(false)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Tuat") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else if(age.equals("Hoi") && sex.equals(false)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }else{
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else return new ResponseEntity<>(lists, HttpStatus.OK);
        }
    }
}
