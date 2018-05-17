package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/advisory")
public class AdvisoryController {

    @Autowired
    ProjectDetailService projectDetailService;

    @PostMapping(value = "/{age}+{sex}")
    public ResponseEntity<Object> getDetailsByDirection(@PathVariable("age") String age, @PathVariable("sex") Boolean sex){
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
